package com.alexsantos.foodmenucollegeproject.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

import com.alexsantos.foodmenucollegeproject.model.Product;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alex on 01/03/2017.
 */

public class DataSource {

    private Context mContext;
    private SQLiteDatabase mDatabase;
    SQLiteOpenHelper mDbHelper;


    public DataSource(Context context) {
        this.mContext = context;
        mDbHelper = new DbHelper(mContext);
        mDatabase = mDbHelper.getWritableDatabase();
    }

    public void open() {

        mDatabase = mDbHelper.getWritableDatabase();
    }

    public void close() {

        mDbHelper.close();
    }

    public Product createProduct(Product product) {

        ContentValues values = product.toValue();
        mDatabase.insert(ItemsTable.TABLE_ITEMS, null, values);

        return product;

    }

    public long getDataItemsCount() {
        return DatabaseUtils.queryNumEntries(mDatabase, ItemsTable.TABLE_ITEMS);
    }


    public void seedDatabase(List<Product> dataItemList) {
        long numberOfItem = getDataItemsCount();

        if (numberOfItem == 0) {

            for (Product p : dataItemList) {

                try {
                    createProduct(p);
                } catch (SQLiteException e) {
                    e.printStackTrace();
                }

            }
        }

    }

    public List<Product> getAllProduct(String category) {

        List<Product> dataItems = new ArrayList<>();

        Cursor cursor=null;
        if(category ==null){

            cursor = mDatabase.query(ItemsTable.TABLE_ITEMS, ItemsTable.ALL_COLLUMS, null,
                    null, null, null, ItemsTable.COLUMN_NAME);
        }else{
            String[] categories ={category};
            cursor = mDatabase.query(ItemsTable.TABLE_ITEMS, ItemsTable.ALL_COLLUMS, ItemsTable.COLUMN_CATEGORY+"=?",
                    categories, null, null, ItemsTable.COLUMN_NAME);
        }




        while (cursor.moveToNext()) {
            Product item = new Product();
            item.setProductId(cursor.getString(
                    cursor.getColumnIndex(ItemsTable.COLUMN_ID)));
            item.setProductName(cursor.getString(
                    cursor.getColumnIndex(ItemsTable.COLUMN_NAME)));
            item.setDescription(cursor.getString(
                    cursor.getColumnIndex(ItemsTable.COLUMN_DESCRIPTION)));
            item.setCategory(cursor.getString(
                    cursor.getColumnIndex(ItemsTable.COLUMN_CATEGORY)));
            item.setSortposition(cursor.getInt(
                    cursor.getColumnIndex(ItemsTable.COLUMN_ID)));
            item.setPrice(cursor.getDouble(
                    cursor.getColumnIndex(ItemsTable.COLUMN_PRICE)));
            item.setImage(cursor.getString(
                    cursor.getColumnIndex(ItemsTable.COLUMN_IMAGE)));
            dataItems.add(item);

        }
        cursor.close();

        return dataItems;
    }
}
