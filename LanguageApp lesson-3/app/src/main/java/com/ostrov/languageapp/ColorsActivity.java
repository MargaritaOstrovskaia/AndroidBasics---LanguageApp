package com.ostrov.languageapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class ColorsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        // Create list of colors
        ArrayList<Word> colors = new ArrayList<>();
        colors.add(new Word("красный", "red", R.drawable.color_red));
        colors.add(new Word("зеленый", "green", R.drawable.color_green));
        colors.add(new Word("коричневый", "brown", R.drawable.color_brown));
        colors.add(new Word("серый", "gray", R.drawable.color_gray));
        colors.add(new Word("черный", "black", R.drawable.color_black));
        colors.add(new Word("белый", "white", R.drawable.color_white));
        colors.add(new Word("горчично-желтый", "yellow", R.drawable.color_mustard_yellow));
        colors.add(new Word("пыльно-желтый", "blue", R.drawable.color_dusty_yellow));

        // Create custom Adapter for this word list
        WordAdapter adapter = new WordAdapter(this, colors, getColor(R.color.category_colors));

        // Set this adapter for ListView
        ListView listView = findViewById(R.id.root);
        listView.setAdapter(adapter);
    }
}
