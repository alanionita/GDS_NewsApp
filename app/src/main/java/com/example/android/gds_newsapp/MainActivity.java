package com.example.android.gds_newsapp;

import android.app.LoaderManager;
import android.content.Context;
import android.content.Loader;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Objects;

public class MainActivity
        extends AppCompatActivity
        implements LoaderManager.LoaderCallbacks<ArrayList<Story>> {
    /** Tag for the log messages */
    public static final String LOG_TAG = MainActivity.class.getSimpleName();

    // Local Globals
    private static final String GUARDIAN_REQUEST_URL = "https://content.guardianapis.com/search?show-tags=contributor&show-elements=image&q=brexit&api-key=3d9afde5-908f-407e-a77c-c81994fc9bee";
    private static final int STORY_LOADER_ID = 1;
    private StoryListAdapter listAdapter;
    private TextView stateTextView;
    private ProgressBar progressBar;
    private boolean isConnected;

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get the actionBar and set to a different title
        Objects.requireNonNull(getSupportActionBar()).setTitle(R.string.app_title);

        // Find the listView in the layout
        ListView storiesList = findViewById(R.id.list);
        assert storiesList != null;

        // Get stateTextView and set list empty view to it
        stateTextView = findViewById(R.id.state_textView);
        storiesList.setEmptyView(stateTextView);

        // Get ProgressBar
        progressBar = findViewById(R.id.indeterminateBar);

        // Checks for internet connectivity
        ConnectivityManager cm =
                (ConnectivityManager) this.getSystemService(Context.CONNECTIVITY_SERVICE);

        assert cm != null;
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        isConnected = activeNetwork != null &&
                activeNetwork.isConnectedOrConnecting();

        // Create and set a new StoryListAdapter
        listAdapter = new StoryListAdapter(this, new ArrayList<Story>());
        storiesList.setAdapter(listAdapter);

        // Start LoaderManager and initialise loader
        if (isConnected) {
            LoaderManager loaderManager = getLoaderManager();
            loaderManager.initLoader(STORY_LOADER_ID, null, this);
        } else {
            progressBar.setVisibility(ProgressBar.GONE);
            stateTextView.setText(R.string.no_internet);
        }

    }

    @Override
    public Loader<ArrayList<Story>> onCreateLoader(int i, Bundle bundle) {
        progressBar.setVisibility(ProgressBar.VISIBLE);
        return new StoryLoader(this, GUARDIAN_REQUEST_URL);
    }

    @Override
    public void onLoadFinished(
            Loader<ArrayList<Story>> loader,
            ArrayList<Story> stories) {
        progressBar.setVisibility(ProgressBar.GONE);
        stateTextView.setText(R.string.no_data_in_list);
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
