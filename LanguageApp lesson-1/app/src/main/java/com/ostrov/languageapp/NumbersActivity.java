package com.ostrov.languageapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.TextView;

public class NumbersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);

        String[] words = new String[10];
        words[0] = "one";
        words[1] = "two";
        words[2] = "three";
        words[3] = "four";
        words[4] = "five";
        words[5] = "six";
        words[6] = "seven";
        words[7] = "eight";
        words[8] = "nine";
        words[9] = "ten";

        LinearLayout root = findViewById(R.id.rootNumbers);
        int count = 0;
        while (count < words.length){
            Log.v("NumbersActivity", String.format("Word at index %d: ", count) + words[count]);

            TextView textView = new TextView(root.getContext());
            textView.setText(words[count]);
            root.addView(textView);

            count = count + 1;
        }
    }
}
