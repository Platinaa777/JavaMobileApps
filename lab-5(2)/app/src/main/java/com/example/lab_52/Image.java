package com.example.lab_52;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Image {
    private String name; // название
    private int imageRes; // картинка

    public Image(String name, int image) {
        this.name = name;
        this.imageRes = image;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImageResource() {
        return this.imageRes;
    }

    public void setImageResource(int flagResource) {
        this.imageRes = flagResource;
    }
}

