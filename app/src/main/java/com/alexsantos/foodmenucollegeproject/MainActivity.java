package com.alexsantos.foodmenucollegeproject;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.preference.PreferenceManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.alexsantos.foodmenucollegeproject.database.DataSource;
import com.alexsantos.foodmenucollegeproject.database.DbHelper;
import com.alexsantos.foodmenucollegeproject.model.Product;
import com.alexsantos.foodmenucollegeproject.sample.SampleDataProvider;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    public static final String MY_GLOBAL_PREFS = "my_global_prefs";
    List<Product> listItem = SampleDataProvider.dataItem;
    DataSource mDataSource;
    String [] mCategories;
    ListView mDrawerList;
    DrawerLayout mDrawerLayout;
    List<Product> listFromDatabase;
    DataProductAdapter adapter;
    RecyclerView  recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //code to manage navigation drawer
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mCategories = getResources().getStringArray(R.array.categories);
        mDrawerList = (ListView) findViewById(R.id.left_drawer);
        recyclerView = (RecyclerView) findViewById(R.id.rvItems);
        mDrawerList.setAdapter(new ArrayAdapter<>(this,R.layout.drawer_list_item,mCategories));


        mDrawerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String category = mCategories[position];
                Toast.makeText(MainActivity.this,"Choice "+category+" selected",Toast.LENGTH_SHORT).show();
                mDrawerLayout.closeDrawer(mDrawerList);
                displayItems(category);
            }
        });


        mDataSource  = new DataSource(this);
        mDataSource.open();
        mDataSource.seedDatabase(listItem);


        SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(this);
        boolean grid = settings.getBoolean(getString(R.string.pref_display_in_grid),false);

        if(grid){

            recyclerView.setLayoutManager(new GridLayoutManager(this,3));
        }

        displayItems(null);

    }

    private void displayItems(String category){
       listFromDatabase = mDataSource.getAllProduct(category);
        adapter = new DataProductAdapter(this,listFromDatabase);
        recyclerView.setAdapter(adapter);
    }



    @Override
    protected void onPause() {
        super.onPause();
        mDataSource.close();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mDataSource.open();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

       getMenuInflater().inflate(R.menu.main_menu,menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){

            case R.id.action_settings:
                Intent settingIntent = new Intent(this, PreferenceActivity.class);
                startActivity(settingIntent);
                return true;

            case R.id.action_display_all_Products:
                // display all product
                displayItems(null);
                return true;


            case R.id.action_choose_category:
                mDrawerLayout.openDrawer(mDrawerList);
                return true;

        }
        return super.onOptionsItemSelected(item);
    }


}
