package com.example.davidarisz.davidarisz_pset2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

import java.io.InputStream;

public class FillWordsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fill_words);
    }

    private void ding() {
        InputStream story = getResources().openRawResource(R.raw.madlib0_simple);
        Story simple = new Story(story);

        EditText et = findViewById(R.id.editText);

        System.out.println(story);
    }
}
