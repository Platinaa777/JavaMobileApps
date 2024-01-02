package com.example.lab_7;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.yandex.mapkit.Animation;
import com.yandex.mapkit.MapKitFactory;
import com.yandex.mapkit.geometry.Point;
import com.yandex.mapkit.map.CameraPosition;
import com.yandex.mapkit.mapview.MapView;

public class MainActivity extends AppCompatActivity {

    private static MapView mapView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        MapKitFactory.setApiKey("a8991710-dfa7-4cc9-a50a-66fed1f16762");
        MapKitFactory.initialize(this);
        setContentView(R.layout.activity_main);
        super.onCreate(savedInstanceState);

        mapView = findViewById(R.id.map_view);
        mapView.getMap().setRotateGesturesEnabled(false);
        mapView.getMap().move(new CameraPosition(
                new Point(52.256120, 104.253059), 14, 0, 0));
    }

    @Override
    protected void onStop() {
        mapView.onStop();
        MapKitFactory.getInstance().onStop();
        super.onStop();
    }

    @Override
    protected void onStart() {
        mapView.onStart();
        MapKitFactory.getInstance().onStart();
        super.onStart();
    }
}