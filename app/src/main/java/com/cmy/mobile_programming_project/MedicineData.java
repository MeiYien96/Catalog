package com.cmy.mobile_programming_project;

import android.widget.ImageView;

public class MedicineData {
    private int id;
    private String name;
    private double price;
    private ImageView image;

    public MedicineData(int id,String name, double price,ImageView image) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public ImageView getImage() {
        return image;
    }
}
