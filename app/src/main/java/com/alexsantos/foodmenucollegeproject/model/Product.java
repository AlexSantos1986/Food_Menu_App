package com.alexsantos.foodmenucollegeproject.model;

import java.util.UUID;

/**
 * Created by Alex on 24/02/2017.
 */

public class Product {


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


}
