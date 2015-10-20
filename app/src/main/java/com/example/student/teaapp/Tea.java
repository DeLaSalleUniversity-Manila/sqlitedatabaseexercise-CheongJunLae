package com.example.student.teaapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class Tea {
    private String name;
    private String description;
    private int imageResourceId;


    public static final Tea[] teas = {
            new Tea ("Longjing", "Maybe the most well-known green tea in China",
                    R.drawable.longjing),
            new Tea("Maofeng", "Meaning: furry peak",
                    R.drawable.maofeng),
            new Tea("Biluochun", "A Chinese famous tea also known as Green Snail Spring",
                    R.drawable.biluochun)
    };

    private Tea(String name, String description, int imageResourceId) {
        this.name = name;
        this.description = description;
        this.imageResourceId = imageResourceId;
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }

    public String toString() {
        return this.name;
    }
}