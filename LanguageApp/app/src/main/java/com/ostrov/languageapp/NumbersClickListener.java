package com.ostrov.languageapp;

import android.content.Intent;
import android.view.View;

public class NumbersClickListener implements View.OnClickListener  {
    @Override
    public void onClick(View view) {
        Intent intent = new Intent(view.getContext(), NumbersActivity.class);
        view.getContext().startActivity(intent);
    }
}
