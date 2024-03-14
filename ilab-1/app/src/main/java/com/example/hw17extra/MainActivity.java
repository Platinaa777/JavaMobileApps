package com.example.hw17extra;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GestureDetectorCompat;

import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.GestureDetector;
import android.view.GestureDetector.OnDoubleTapListener;
import android.view.GestureDetector.OnGestureListener;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.widget.TextView;
import android.widget.Toast;

import java.text.MessageFormat;

public class MainActivity extends AppCompatActivity implements OnGestureListener, OnDoubleTapListener {

    private GestureDetectorCompat gestureDetector;
    TextView gestureInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gestureDetector = new GestureDetectorCompat(this, this);
        gestureDetector.setOnDoubleTapListener(this);
        gestureInfo = findViewById(R.id.gesture_info);
        gestureInfo.setMovementMethod(new ScrollingMovementMethod());
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (gestureDetector.onTouchEvent(event)) {
            return true;
        }
        return super.onTouchEvent(event);
    }

    @Override
    public boolean onSingleTapConfirmed(MotionEvent e) {
        Log.d("Action", "Single tap: " + e.toString());
        gestureInfo.setText("Single tap detected");
        return true;
    }

    @Override
    public boolean onDoubleTap(MotionEvent e) {
        Log.d("Action","Double tap: " + e.toString());
        return true;
    }

    @Override
    public boolean onDoubleTapEvent(MotionEvent e) {
        Log.d("Action", "Double tap event: " + e.toString());
        gestureInfo.setText("Double tap detected");
        return true;
    }

    @Override
    public boolean onDown(MotionEvent e) {
        Log.d("Action","On down: " + e.toString());
        gestureInfo.setText("Down gesture detected");
        return true;
    }

    @Override
    public void onShowPress(MotionEvent e) {
        Log.d("Action","on show press: " + e.toString());
        gestureInfo.setText("Show press gesture detected");
    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        Log.d("Action","Single tap up: " + e.toString());
        gestureInfo.setText("Single tap up detected");
        return true;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        Log.d("Action","On scroll: " + e1.toString() + ", " + e2.toString());
        gestureInfo.setText("Scroll gesture detected");
        return true;
    }

    @Override
    public void onLongPress(MotionEvent e) {
        Log.d("Action", "onLongPress: " + e.toString());
        gestureInfo.setText("Long press gesture detected");
    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        Log.d("Action", "On fling: " + e1.toString() + ", " + e2.toString());
        gestureInfo.setText("Fling gesture detected");
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(MainActivity.this);
        try {
            dialogBuilder.setMessage(getTitle().toString() + " версия " +
                    getPackageManager().getPackageInfo(getPackageName(), 0).versionName +
                    "\r\n\nПрограмма для жестов\r\n\nАвтор - Мирошниченко Денис Александрович БПИ225");
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        dialogBuilder.setTitle("О программе");
        dialogBuilder.setNeutralButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        dialogBuilder.setIcon(R.mipmap.ic_launcher_round);
        AlertDialog alertDialog = dialogBuilder.create();
        alertDialog.show();
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }
}