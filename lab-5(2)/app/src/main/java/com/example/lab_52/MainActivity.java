package com.example.lab_52;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<Image> images = new ArrayList<Image>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setData();
        RecyclerView recyclerView = findViewById(R.id.review);
        CustomRecyclerAdapter adapter = new CustomRecyclerAdapter(this,
                images);
        recyclerView.setAdapter(adapter);
    }
    private void setData(){
        images.add(new Image ("dog1", R.drawable.image1));
        images.add(new Image ("dog2", R.drawable.image2));
        images.add(new Image ("dog3", R.drawable.image3));
        images.add(new Image ("dog4", R.drawable.image4));
    }
}