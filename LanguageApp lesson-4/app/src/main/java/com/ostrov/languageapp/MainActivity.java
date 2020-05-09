package com.ostrov.languageapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Find the view pager that will allow the user to swipe between fragments
        final ViewPager pager = findViewById(R.id.view_pager);

        // Create an adapter that knows which fragment should be shown on each page
        CategoryAdapter adapter = new CategoryAdapter(getSupportFragmentManager(), this);

        // Set the adapter onto the view pager
        pager.setAdapter(adapter);

        // Find the tab layout that shows the tabs
        TabLayout tabLayout = findViewById(R.id.sliding_tabs);

        // Connect the tab layout with the view pager. This will
        // - Update the tab layout when the view pager is swiped
        // - Update the view pager when a tab is selected
        // - Set the tab layout's tab names with the view pager's adapter's titles by calling onPageTitle()
        tabLayout.setupWithViewPager(pager);
    }
}