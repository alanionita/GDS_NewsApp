package com.example.android.gds_newsapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Create the list of stories
        ArrayList<Story> stories = QueryUtils.extractStories();

        // Find the listView in the layout
        ListView storiesList = (ListView) findViewById(R.id.list);

        // Create a new StoryListAdapter
        StoryListAdapter adapter = new StoryListAdapter(this, stories);

        // Set adapter on ListView
        storiesList.setAdapter(adapter);

    }
}
