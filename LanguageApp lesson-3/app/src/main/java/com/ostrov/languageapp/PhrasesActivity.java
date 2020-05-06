package com.ostrov.languageapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class PhrasesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        // Create list of phrases
        ArrayList<Word> phrases = new ArrayList<>();
        phrases.add(new Word("Куда ты идешь?", "Where are you going?"));
        phrases.add(new Word("Как твое имя?", "What is your name?"));
        phrases.add(new Word("Мое имя...", "My name is...", -1));
        phrases.add(new Word("Как ты себя чувствуешь?", "How are you feeling?"));
        phrases.add(new Word("Я чувствую себя хорошо.", "I’m feeling good."));
        phrases.add(new Word("Ты придешь?", "Are you coming?"));
        phrases.add(new Word("Да, я приду.", "Yes, I’m coming."));
        phrases.add(new Word("Давай.", "Let’s go."));
        phrases.add(new Word("Иди сюда.", "Come here."));

        // Create custom Adapter for this word list
        WordAdapter adapter = new WordAdapter(this, phrases, getColor(R.color.category_phrases));

        // Set this adapter for ListView
        ListView listView = findViewById(R.id.root);
        listView.setAdapter(adapter);
    }
}
