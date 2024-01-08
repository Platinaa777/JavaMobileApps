package com.example.android_labs;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView textView = findViewById(R.id.textView);
        final EditText editText = findViewById(R.id.editTextText);
        Button button = (Button) findViewById(R.id.button);
        textView.setText("");
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final TextView textView = findViewById(R.id.textView);
                final EditText editText = findViewById(R.id.editTextText);
                Button button = (Button) findViewById(R.id.button);
                textView.setText("");

                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        textView.setText("Привет, " +
                                editText.getText().toString() + "!");
                    }
                });
            }
        });
    }

}