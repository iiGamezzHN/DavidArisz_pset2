package com.example.davidarisz.davidarisz_pset2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import static com.example.davidarisz.davidarisz_pset2.FillWordsActivity.STORY_TAG;

public class FinalStoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_story);

        // Get story and words from intent
        Story story = (Story) getIntent().getSerializableExtra(STORY_TAG);
        // Fill story
        TextView tv = findViewById(R.id.finalStory);
        tv.setText(story.toString());
    }

}
