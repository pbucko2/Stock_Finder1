package com.example.stockfinder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import java.util.Arrays;
import java.util.List;

public class LaunchActivity extends AppCompatActivity {
    public void start() {
        startActivity(new Intent(this, Main2Activity.class));
    }
    @Override
    protected final void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch);

        Button start = findViewById(R.id.start);

        start.setOnClickListener(v -> {
            start();
        });


        }
    }
