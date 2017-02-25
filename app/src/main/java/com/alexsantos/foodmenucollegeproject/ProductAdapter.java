package com.alexsantos.foodmenucollegeproject;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import com.alexsantos.foodmenucollegeproject.model.Product;

import java.util.List;
import java.util.Objects;

/**
 * Created by Alex on 24/02/2017.
 */

public class ProductAdapter extends ArrayAdapter<Product> {

    List<Product> dataProduct;
    LayoutInflater inflater;

    public ProductAdapter(Context context, List<Product> objects) {
        super(context, R.layout.product_list, objects);

        dataProduct = objects;
        inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {

            convertView = inflater.inflate(R.layout.product_list,parent,false);
        }

        TextView tvName = (TextView) convertView.findViewById(R.id.productNameText);
        ImageView imageView = (ImageView) convertView.findViewById(R.id.imageView);

        Product p = dataProduct.get(position);


        tvName.setText(p.getProductName());
        imageView.setImageResource(R.drawable.swiss_roll);


        return convertView;
    }
}
