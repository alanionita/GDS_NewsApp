package com.example.android.gds_newsapp;

import android.app.LoaderManager;
import android.content.Loader;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

// TODO: Refactor to use loaders for: downloading avatars
// TODO: Add state to the app for: no items in list
// TODO: Add state to the app for: fetching data (progressBar)
// TODO: Add state to the app for: no internet connection
// TODO: Check code formatting, fix errors, optimise imports
// TODO: Optimise build
// TODO: Write a professional README
// TODO: Optional: change the name in the AppBar from project name to 'News'
// TODO: Optional: Add API_key to a config file (env variable)

public class MainActivity
        extends AppCompatActivity
        implements LoaderManager.LoaderCallbacks<ArrayList<Story>> {
    /** Tag for the log messages */
    public static final String LOG_TAG = MainActivity.class.getSimpleName();

    /** URL to query the Guardian API for Brexit News articles */
    private static final String GUARDIAN_REQUEST_URL = "https://content.guardianapis.com/search?show-tags=contributor&show-elements=image&q=brexit&api-key=3d9afde5-908f-407e-a77c-c81994fc9bee";

    // Global for the story loader ID
    private static final int STORY_LOADER_ID = 1;
    // Global for listAdaptor
    private StoryListAdapter listAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Find the listView in the layout
        ListView storiesList = findViewById(R.id.list);
        assert storiesList != null;

        // Create and set a new StoryListAdapter
        listAdapter = new StoryListAdapter(this, new ArrayList<Story>());
        storiesList.setAdapter(listAdapter);

        // Start LoaderManager and initialise loader
        LoaderManager loaderManager = getLoaderManager();
        loaderManager.initLoader(STORY_LOADER_ID, null, this);
    }

    @Override
    public Loader<ArrayList<Story>> onCreateLoader(int i, Bundle bundle) {
        return new StoryLoader(this, GUARDIAN_REQUEST_URL);
    }

    @Override
    public void onLoadFinished(
            Loader<ArrayList<Story>> loader,
            ArrayList<Story> stories) {

        listAdapter.clear();

        if (stories != null && !stories.isEmpty()) {
            listAdapter.addAll(stories);
        }
    }

    @Override
    public void onLoaderReset(Loader<ArrayList<Story>> loader) {
        listAdapter.clear();
    }
}
