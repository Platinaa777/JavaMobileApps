package com.example.hw7;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import com.yandex.mapkit.Animation;
import com.yandex.mapkit.MapKitFactory;
import com.yandex.mapkit.geometry.Point;
import com.yandex.mapkit.map.CameraListener;
import com.yandex.mapkit.map.CameraPosition;
import com.yandex.mapkit.map.CameraUpdateReason;
import com.yandex.mapkit.map.Map;
import com.yandex.mapkit.map.MapObjectCollection;
import com.yandex.mapkit.map.PlacemarkMapObject;
import com.yandex.mapkit.mapview.MapView;

import com.example.hw7.databinding.ActivityMainBinding;
import com.yandex.runtime.image.ImageProvider;

import java.util.Objects;

public class MainActivity extends AppCompatActivity implements CameraListener {

    private MapView mapView;
    private static final Point home = new Point( 55.669803, 37.279653);
    private MapObjectCollection mapObjectCollection;
    private PlacemarkMapObject userLocationMarker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String apiKey = "7c33579e-ca48-48c4-8076-e2df8f14fe88";
        MapKitFactory.setApiKey(apiKey);
        MapKitFactory.initialize(this);

        com.example.hw7.databinding.ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        mapView = binding.map;
        mapView.getMap().addCameraListener(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        mapView.onStop();
        MapKitFactory.getInstance().onStop();
    }

    @Override
    protected void onStart() {
        super.onStart();
        mapView.onStart();
        MapKitFactory.getInstance().onStart();
    }

    private void setUserLocationMarker(Point location) {
        if (userLocationMarker != null) {
            mapView.getMap().getMapObjects().remove(userLocationMarker);
        }
        Bitmap markerBitmap = createBitmapFromVector(R.drawable.ic_pin_black_svg);
        if (markerBitmap != null) {
            userLocationMarker = mapView.getMap().getMapObjects().addPlacemark(location, ImageProvider.fromBitmap(markerBitmap));
        }
    }

    private Bitmap createBitmapFromVector(int art) {
        Drawable drawable = ContextCompat.getDrawable(this, art);
        if (drawable == null)
            return null;
        Bitmap bitmap = Bitmap.createBitmap(
                drawable.getIntrinsicWidth(),
                drawable.getIntrinsicHeight(),
                Bitmap.Config.ARGB_8888
        );
        Canvas canvas = new Canvas(bitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);
        return bitmap;
    }

    @Override
    public void onCameraPositionChanged(@NonNull Map map, @NonNull CameraPosition cameraPosition, @NonNull CameraUpdateReason cameraUpdateReason, boolean b) {
        setUserLocationMarker(home);
    }
}