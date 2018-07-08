package com.example.android.gds_newsapp;

import android.content.AsyncTaskLoader;
import android.content.Context;

import java.util.ArrayList;

public class StoryLoader extends AsyncTaskLoader<ArrayList<Story>> {
    private String urlHolder;

    StoryLoader(Context context, String url) {
        super(context);
        urlHolder = url;
    }

    @Override
    public ArrayList<Story> loadInBackground() {
        if (urlHolder == null) {
            return null;
        }
        return QueryUtils.fetchStoryData(urlHolder);
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }
}
