package com.ostrov.languageapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.ArrayList;

public class FamilyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_family);

        // Create list of colors
        ArrayList<String> family = new ArrayList<>();
        family.add("father");
        family.add("mother");
        family.add("son");
        family.add("daughter");
        family.add("older brother");
        family.add("younger brother");
        family.add("older sister");
        family.add("younger sister");
        family.add("grandmother");
        family.add("grandfather");
    }
}
