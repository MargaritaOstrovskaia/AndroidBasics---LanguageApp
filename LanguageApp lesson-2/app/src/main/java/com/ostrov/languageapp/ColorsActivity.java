package com.ostrov.languageapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.GridView;

import java.util.ArrayList;

public class ColorsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colors);

        // Create list of colors
        ArrayList<String> colors = new ArrayList<>();
        colors.add("red");
        colors.add("green");
        colors.add("brown");
        colors.add("gray");
        colors.add("black");
        colors.add("white");
        colors.add("dusty yellow");
        colors.add("mustard yellow");

        // Create Adapter for this color list.
        // The first parameter is used to pass the context means the reference of current class.
        // The second parameter is resource id used to set the layout(xml file) for list items in which you have a text view.
        // The third parameter is textViewResourceId which is used to set the id of TextView where you want to display the actual text.
        ArrayAdapter<String> adapter =
                new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, colors);

        // Set this adapter for GridView
        GridView view = findViewById(R.id.rootColors);
        view.setAdapter(adapter);
    }
}
