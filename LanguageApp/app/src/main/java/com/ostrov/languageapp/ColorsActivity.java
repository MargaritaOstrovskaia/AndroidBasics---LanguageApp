package com.ostrov.languageapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class ColorsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colors);

        ArrayList<String> colors = new ArrayList<>();
        colors.add("Red");
        colors.add("Green");

        LinearLayout root = findViewById(R.id.rootColors);
        for (int i = 0; i < colors.size(); i++) {
            Log.v("ColorsActivity", String.format("Word at index %d: ", i) + colors.get(i));

            TextView textView = new TextView(root.getContext());
            textView.setText(colors.get(i));
            root.addView(textView);
        }
    }
}
