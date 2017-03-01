package com.alexsantos.foodmenucollegeproject.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;

/**
 * Created by Alex on 01/03/2017.
 */

public class DbHelper extends SQLiteOpenHelper {

    static final int VERSION= 5;
    static final String FILE_NAME="foodMenu.db";


    public DbHelper(Context context) {
        super(context, FILE_NAME,null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(ItemsTable.SQL_CREATE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL(ItemsTable.SQL_DELETE);
        onCreate(db);

    }
}
