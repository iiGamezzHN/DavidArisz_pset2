package com.example.davidarisz.davidarisz_pset2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final String STORY_SELECT = "Select story";
    public static final String STORY_SIMPLE = "Simple story";
    public static final String STORY_TARZAN = "Tarzan story";
    public static final String STORY_UNIVERSITY = "University story";
    public static final String STORY_CLOTHES = "Clothes story";
    public static final String STORY_DANCE = "Dance story";
    public static final String SELECTED_TAG = "selected_tag";
    public String selected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner dropdown = findViewById(R.id.spinner1);
        // Create a list of items for the spinner.
        String[] items = new String[]{STORY_SELECT, STORY_SIMPLE, STORY_TARZAN, STORY_UNIVERSITY, STORY_CLOTHES, STORY_DANCE};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
        // Set the spinners adapter to the previously created one.
        dropdown.setAdapter(adapter);
        dropdown.setOnItemSelectedListener(new MySpinnerSelectedListener());

    }

    // Change the activity from MainActivity to FillWordsActivity
    public void changeActivity(View v) {
        if(selected == STORY_SELECT) { // If no story is selected it won't continue
            Toast.makeText(this, "Select a story!", Toast.LENGTH_SHORT).show();
        } else {
            Intent intent = new Intent(getApplicationContext(), FillWordsActivity.class);
            intent.putExtra(SELECTED_TAG, selected); // Put the selected story in the intent
            startActivity(intent);
        }
    }

    // A listener for the spinner, which checks what option in the spinner is selected
    public class MySpinnerSelectedListener implements AdapterView.OnItemSelectedListener {
        public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
            selected = parent.getItemAtPosition(pos).toString();
        }
        public void onNothingSelected(AdapterView parent) {
            // Do nothing.
        }
    }

}
