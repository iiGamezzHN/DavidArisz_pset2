package com.example.davidarisz.davidarisz_pset2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.io.InputStream;
import java.io.Serializable;
import java.util.List;

import static com.example.davidarisz.davidarisz_pset2.MainActivity.SELECTED_TAG;
import static com.example.davidarisz.davidarisz_pset2.MainActivity.STORY_CLOTHES;
import static com.example.davidarisz.davidarisz_pset2.MainActivity.STORY_DANCE;
import static com.example.davidarisz.davidarisz_pset2.MainActivity.STORY_SIMPLE;
import static com.example.davidarisz.davidarisz_pset2.MainActivity.STORY_TARZAN;
import static com.example.davidarisz.davidarisz_pset2.MainActivity.STORY_UNIVERSITY;

public class FillWordsActivity extends AppCompatActivity {

    public static final String STORY_TAG = "story_tag";
    private EditText et;
    private Story story;
    private TextView textView;
    private String left;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fill_words);
        String selection = getIntent().getStringExtra(SELECTED_TAG); // The selected story

        // Create story
        InputStream rawStory;
        switch (selection) { // Check which story was selected and store it
            case STORY_SIMPLE:
                rawStory = getResources().openRawResource(R.raw.madlib0_simple);
                break;
            case STORY_TARZAN:
                rawStory = getResources().openRawResource(R.raw.madlib1_tarzan);
                break;
            case STORY_UNIVERSITY:
                rawStory = getResources().openRawResource(R.raw.madlib2_university);
                break;
            case STORY_CLOTHES:
                rawStory = getResources().openRawResource(R.raw.madlib3_clothes);
                break;
            case STORY_DANCE:
                rawStory = getResources().openRawResource(R.raw.madlib4_dance);
                break;
            default:
                rawStory = getResources().openRawResource(R.raw.madlib0_simple);
                break;
        }

        // Restore the story if one is saved in savedInstanceState
        if(savedInstanceState != null) {
            story = (Story) savedInstanceState.getSerializable("storyTag");
            List placeholders = (List) savedInstanceState.getSerializable("placeholderTag");
            story.setPlaceholders(placeholders);
            assert story != null; // No bugging notification about possible NullPointerException
        } else {
            story = new Story(rawStory);
        }

        // Get EditText object
        et = findViewById(R.id.word_edittext);
        textView = findViewById(R.id.fill_nr_left);

        // Set first hint
        et.setHint(story.getNextPlaceholder());

        left = story.getPlaceholderRemainingCount() + " words are left.";
        textView.setText(left); // Show how many words are left to fill in
    }

    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);

        List<String> placeholders = story.getPlaceholders(); // Get the current placeholders

        savedInstanceState.putSerializable("storyTag", story); // Save the story
        savedInstanceState.putSerializable("placeholderTag",(Serializable) placeholders); // Save the placeholders
    }

    /**
     * this method fills in the placeholder you just answered
     * then checks if all the placeholders are filled in and opens next activity if they are
     * if they aren't it sets the hint for the next placeholder
     * and sets the remaining number of words to a a TextView
     * @param v
     */
    public void next(View v) {
        story.fillInPlaceholder(et.getText().toString());
        if (story.isFilledIn()) {
            Intent intent = new Intent(this, FinalStoryActivity.class);
            intent.putExtra(STORY_TAG, story);
            startActivity(intent);
        }
        et.setText("");
        et.setHint(story.getNextPlaceholder());

        left = story.getPlaceholderRemainingCount() + " words are left";
        textView.setText(left);
    }
}
