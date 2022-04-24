package com.hfad.mynotes.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.hfad.mynotes.R;
import com.hfad.mynotes.domain.Notes;

public class DogsDetailsActivity extends AppCompatActivity {
    private static final String EXTRA_NOTES = "EXTRA_NOTES";

    public static void show(Context context, Notes notes) {
        Intent intent = new Intent(context, DogsDetailsFragment.class);
        intent.putExtra(EXTRA_NOTES, notes);
        context.startActivity(intent);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dogs_details);
        if (savedInstanceState == null) {
            Notes notes = getIntent().getParcelableExtra(EXTRA_NOTES);
            DogsDetailsFragment dogsDetailsFragment = DogsDetailsFragment.newInstance(notes);
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.container, dogsDetailsFragment)
                    .commit();
        }
    }
}