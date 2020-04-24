package com.ostrov.languageapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * {@link WordAdapter} is an {@link ArrayAdapter} that can provide the layout
 * for each list based on a data source,
 * which is a list of {@link Word} objects.
 */
public class WordAdapter extends ArrayAdapter<Word> {
    /**
     * This is our own custom constructor (it doesn't mirror a superclass constructor).
     * The context is used to inflate the layout file, and the list is the data we want
     * to populate into the lists.
     *
     * @param context The current context. Used to inflate the layout file.
     * @param words A List of word objects to display in a list
     */
    public WordAdapter(Context context, ArrayList<Word> words) {
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // The second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews and an ImageView,
        // the adapter is not going to use this second argument,
        // so it can be any value. Here, we used 0.
        super(context, 0, words);
    }


    /**
     * Provides a view for an AdapterView (ListView, GridView, etc.)
     *
     * @param position The position in the list of data that should be displayed in the list item view.
     * @param convertView The recycled view to populate.
     * @param parent The parent ViewGroup that is used for inflation.
     * @return The View for the position in the AdapterView.
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view.
        View listItemView = convertView;
        if (listItemView == null)
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);

        // Get the Word object located at this position in the list
        Word w = getItem(position);
        if (w != null) {
            // Find the TextView in the list_item.xml layout with the ID version_name
            // Get the text (default word) from the current Word object
            // Set this text on the defaultWord TextView
            TextView defaultWord = listItemView.findViewById(R.id.default_language_text_view);
            defaultWord.setText(w.getDefaultWord());

            TextView englishWord = listItemView.findViewById(R.id.english_text_view);
            englishWord.setText(w.getEnglishWord());

            ImageView img = listItemView.findViewById(R.id.img);
            img.setImageResource(w.getmImage());
        }

        // Return the whole list item layout (containing 2 TextViews)
        // so that it can be shown in the ListView
        return listItemView;
    }
}
