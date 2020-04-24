package com.ostrov.languageapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.ArrayList;

public class PhrasesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phrases);

        // Create list of colors
        ArrayList<String> phrases = new ArrayList<>();
        phrases.add("Where are you going?");
        phrases.add("What is your name?");
        phrases.add("My name is...");
        phrases.add("How are you feeling?");
        phrases.add("I’m feeling good.");
        phrases.add("Are you coming?");
        phrases.add("Yes, I’m coming.");
        phrases.add("I’m coming.");
        phrases.add("Let’s go.");
        phrases.add("Come here.");
    }
}
