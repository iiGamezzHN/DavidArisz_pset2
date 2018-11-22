package com.example.davidarisz.davidarisz_pset2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;

import java.io.InputStream;
import java.util.ArrayList;

public class FillWordsActivity extends AppCompatActivity {

    public static final String STORY_TAG = "story_tag";
    private EditText et;
    private Story story;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fill_words);

        // Create story
        InputStream rawStory = getResources().openRawResource(R.raw.madlib1_tarzan);
        story = new Story(rawStory);

        // Get EditText object
        et = findViewById(R.id.word_edittext);
        // Set first hint
        et.setHint(story.getNextPlaceholder());
    }

    public void next(View v) {
        story.fillInPlaceholder(et.getText().toString());
        if (story.isFilledIn()) {
            Intent intent = new Intent(this, FinalStoryActivity.class);
            intent.putExtra(STORY_TAG, story);
            startActivity(intent);
        }
        et.setText("");
        et.setHint(story.getNextPlaceholder());
    }
}
