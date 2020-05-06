package com.ostrov.languageapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        // Create list of words
        ArrayList<Word> words = new ArrayList<>();
        words.add(new Word("один","one", R.drawable.number_one));
        words.add(new Word("два","two", R.drawable.number_two));
        words.add(new Word("три","three", R.drawable.number_three));
        words.add(new Word("четыре","four", R.drawable.number_four));
        words.add(new Word("пять","five", R.drawable.number_five));
        words.add(new Word("шесть","six", R.drawable.number_six));
        words.add(new Word("семь","seven", R.drawable.number_seven));
        words.add(new Word("восемь","eight", R.drawable.number_eight));
        words.add(new Word("девять","nine", R.drawable.number_nine));
        words.add(new Word("десять","ten", R.drawable.number_ten));

        // Create custom Adapter for this word list
        WordAdapter adapter = new WordAdapter(this, words, getColor(R.color.category_numbers));

        // Set this adapter for ListView
        ListView listView = findViewById(R.id.root);
        listView.setAdapter(adapter);
    }
}
