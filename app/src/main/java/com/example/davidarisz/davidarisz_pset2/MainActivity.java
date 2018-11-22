package com.example.davidarisz.davidarisz_pset2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void changeActivity(View v){
        startActivity(new Intent(MainActivity.this, FinalStory.class));
        InputStream story = getResources().openRawResource(R.raw.madlib0_simple);
        Story simple = new Story(story);


    }
}
