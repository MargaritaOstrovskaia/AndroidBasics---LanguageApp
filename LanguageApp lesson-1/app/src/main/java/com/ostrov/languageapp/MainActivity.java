package com.ostrov.languageapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // Find the view that shows the numbers category
        // 1st way to set a clickListener on that View
        NumbersClickListener clickListener = new NumbersClickListener();
        TextView textViewNumbers = findViewById(R.id.numbers);
        textViewNumbers.setOnClickListener(clickListener);

        // Find the view that shows the colors category
        // 2d way to set a clickListener on that View
        TextView textViewColors = findViewById(R.id.colors);
        textViewColors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(view.getContext(), ColorsActivity.class));
            }
        });

    }

    // Find the view that shows the families category
    // 3d way to set a clickListener on that View
    public void onClickFamily(View view) {
        startActivity(new Intent(view.getContext(), FamilyActivity.class));
        // activity_main.xml: In family TextView add attribute android:onClick="onClickFamily"
    }
}