package com.alexsantos.foodmenucollegeproject;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

import com.alexsantos.foodmenucollegeproject.model.Product;
import com.alexsantos.foodmenucollegeproject.sample.SampleDataProvider;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private final static int SIGNIN_REQUEST=1001;
    public static final String MY_GLOBAL_PREFS = "my_global_prefs";

    //    TextView display;
    List<Product> listItem = SampleDataProvider.dataItem;
    List<String> productNames= new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Collections.sort(listItem, new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                return o1.getProductName().compareTo(o2.getProductName());
            }
        });

        DataProductAdapter adapter = new DataProductAdapter(this,listItem);

        SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(this);
        boolean grid = settings.getBoolean(getString(R.string.pref_display_in_grid),false);

        RecyclerView  recyclerView = (RecyclerView) findViewById(R.id.rvItems);
        if(grid){

            recyclerView.setLayoutManager(new GridLayoutManager(this,3));
        }

        recyclerView.setAdapter(adapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

       getMenuInflater().inflate(R.menu.main_menu,menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){

            case R.id.action_signin:
                Intent i = new Intent(this,SigninActivity.class);
                startActivityForResult(i,SIGNIN_REQUEST);
                return true;

            case R.id.action_settings:
                Intent settingIntent = new Intent(this, PreferenceActivity.class);
                startActivity(settingIntent);
                return true;

        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode ==  RESULT_OK && requestCode == SIGNIN_REQUEST){
            String email= data.getStringExtra(SigninActivity.EMAIL_KEY);
            Toast.makeText(this,"You signed in as "+email,Toast.LENGTH_SHORT).show();


            SharedPreferences.Editor editor = getSharedPreferences(MY_GLOBAL_PREFS,MODE_PRIVATE).edit();
            editor.putString(SigninActivity.EMAIL_KEY,email);
            editor.apply();

        }

    }
}
