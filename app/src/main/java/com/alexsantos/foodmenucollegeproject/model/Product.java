package com.alexsantos.foodmenucollegeproject.model;

import android.content.ContentValues;
import android.os.Parcel;
import android.os.Parcelable;

import com.alexsantos.foodmenucollegeproject.database.ItemsTable;

import java.util.UUID;

/**
 * Created by Alex on 24/02/2017.
 */

public class Product implements Parcelable {


    private String productId;
    private String productName;
    private String description;
    private String category;
    private int sortposition;
    private double price;
    private String image;

    public Product() {

    }

    public Product(String productId, String productName, String category, String description, int sortposition, double price, String image) {

        if(productId == null){

            productId = UUID.randomUUID().toString();
        }

        this.productId = productId;
        this.productName = productName;
        this.description=description;
        this.category = category;
        this.sortposition = sortposition;
        this.price = price;
        this.image = image;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getSortposition() {
        return sortposition;
    }

    public void setSortposition(int sortposition) {
        this.sortposition = sortposition;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public ContentValues toValue(){

        ContentValues values = new ContentValues(7);

        values.put(ItemsTable.COLUMN_ID,productId);
        values.put(ItemsTable.COLUMN_NAME,productName);
        values.put(ItemsTable.COLUMN_DESCRIPTION,description);
        values.put(ItemsTable.COLUMN_CATEGORY,category);
        values.put(ItemsTable.COLUMN_POSITION,sortposition);
        values.put(ItemsTable.COLUMN_PRICE,price);
        values.put(ItemsTable.COLUMN_IMAGE,image);

        return values;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.productId);
        dest.writeString(this.productName);
        dest.writeString(this.description);
        dest.writeString(this.category);
        dest.writeInt(this.sortposition);
        dest.writeDouble(this.price);
        dest.writeString(this.image);
    }

    protected Product(Parcel in) {
        this.productId = in.readString();
        this.productName = in.readString();
        this.description = in.readString();
        this.category = in.readString();
        this.sortposition = in.readInt();
        this.price = in.readDouble();
        this.image = in.readString();
    }

    public static final Parcelable.Creator<Product> CREATOR = new Parcelable.Creator<Product>() {
        @Override
        public Product createFromParcel(Parcel source) {
            return new Product(source);
        }

        @Override
        public Product[] newArray(int size) {
            return new Product[size];
        }
    };
}
