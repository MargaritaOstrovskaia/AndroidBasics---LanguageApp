package com.ostrov.languageapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class FamilyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        // Create list of family members
        ArrayList<Word> family = new ArrayList<>();
        family.add(new Word("папа", "father", R.drawable.family_father));
        family.add(new Word("мама", "mother", R.drawable.family_mother));
        family.add(new Word("дочь", "daughter", R.drawable.family_daughter));
        family.add(new Word("сын", "son", R.drawable.family_son));
        family.add(new Word("брат", "brother", R.drawable.family_younger_brother));
        family.add(new Word("сестра", "sister", R.drawable.family_older_sister));
        family.add(new Word("бабушка", "grandmother", R.drawable.family_grandmother));
        family.add(new Word("дедушка", "grandfather", R.drawable.family_grandfather));

        // Create custom Adapter for this word list
        WordAdapter adapter = new WordAdapter(this, family, getColor(R.color.category_family));

        // Set this adapter for ListView
        ListView listView = findViewById(R.id.root);
        listView.setAdapter(adapter);
    }
}
