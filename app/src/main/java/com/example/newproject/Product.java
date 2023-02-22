package com.example.newproject;

import com.google.gson.annotations.SerializedName;

public class Product {

  public   int id,quantity;
   public double price;
    public String title,image,category,description;

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getImage() {
        return image;
    }

    public String getCategory() {
        return category;
    }

    public String getDescription() {
        return description;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;


    }

}
