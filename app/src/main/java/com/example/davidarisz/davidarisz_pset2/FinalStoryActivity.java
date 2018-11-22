package com.example.davidarisz.davidarisz_pset2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class FinalStoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_story);
    }

    public void main(String[] args) throws IOException {
        InputStream inputStream = getResources().openRawResource(R.raw.madlib0_simple);
        BufferedReader bufferedReader= new BufferedReader(new InputStreamReader(inputStream));
        String eachLine = bufferedReader.readLine();
        while (eachLine != null) {
            // `the words in the file are separated by space`, so to get each words
            eachLine = bufferedReader.readLine();
            TextView textView = findViewById(R.id.finalStory);
            textView.setText(eachLine);
        }
    }
}
