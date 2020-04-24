package com.ostrov.languageapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);

        // Create list of words
        ArrayList<Word> words = new ArrayList<>();
        words.add(new Word("один","one", R.drawable.lollipop));
        words.add(new Word("два","two", R.drawable.lollipop));
        words.add(new Word("три","three", R.drawable.lollipop));
        words.add(new Word("четыре","four", R.drawable.lollipop));
        words.add(new Word("пять","five", R.drawable.lollipop));
        words.add(new Word("шесть","six", R.drawable.lollipop));
        words.add(new Word("семь","seven", R.drawable.lollipop));
        words.add(new Word("восемь","eight", R.drawable.lollipop));
        words.add(new Word("девять","nine", R.drawable.lollipop));
        words.add(new Word("десять","ten", R.drawable.lollipop));

        // Create custom Adapter for this word list
        WordAdapter adapter = new WordAdapter(this, words);

        // Set this adapter for ListView
        ListView listView = findViewById(R.id.list);
        listView.setAdapter(adapter);
    }
}
