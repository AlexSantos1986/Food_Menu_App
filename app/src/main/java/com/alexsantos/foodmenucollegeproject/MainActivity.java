package com.alexsantos.foodmenucollegeproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.widget.ListView;

import com.alexsantos.foodmenucollegeproject.model.Product;
import com.alexsantos.foodmenucollegeproject.sample.SampleDataProvider;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MainActivity extends AppCompatActivity {

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
//
//        for(Product p : list){
//            productNames.add(p.getProductName());
//        }
//
//        Collections.sort(productNames);
//
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,productNames);

        DataProductAdapter adapter = new DataProductAdapter(this,listItem);

        RecyclerView view = (RecyclerView) findViewById(R.id.rvItems);
        view.setAdapter(adapter);

    }
}
