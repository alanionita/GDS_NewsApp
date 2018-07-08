package com.example.android.gds_newsapp;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.Log;
import android.widget.ImageView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import static com.example.android.gds_newsapp.MainActivity.LOG_TAG;

/**
 * Created by alanionita on 02/07/2018.
 */

public final class QueryUtils {
    public static ArrayList<Story> extractStory(String jsonData) {
        final ArrayList<Story> storiesHolder = new ArrayList<>();


        if (TextUtils.isEmpty(jsonData)) {
            return null;
        }
        try {
            JSONObject readJSON = new JSONObject(jsonData);
            JSONObject response = readJSON.getJSONObject("response");
            JSONArray results = response.getJSONArray("results");
            Log.i("results length", Integer.toString(results.length()));
            for (int i = 0; i < results.length(); i++) {
                JSONObject storyElem = (JSONObject) results.get(i);
                String webTitle = storyElem.getString("webTitle");
                String sectionName = storyElem.getString("sectionName");
                String rawWebPublicationDate = storyElem.getString("webPublicationDate");
                String parsedPublicationDate = HelperUtils.parseDateString(rawWebPublicationDate);
                String webUrl = storyElem.getString("webUrl");
                JSONArray tags = storyElem.getJSONArray("tags");
                ArrayList<String> authors = new ArrayList<>();
                String authorAvatarURL = null;
                Bitmap authorAvatar = null;

                // Finds authors if tag object is present
                if (tags.length() > 0) {
                    for (int j = 0; j < tags.length(); j++) {
                        JSONObject individualTag = (JSONObject) tags.get(j);
                        String author = individualTag.getString("webTitle");
                        authorAvatarURL = individualTag.getString("bylineImageUrl");
                        authors.add(author);
                    }
                }

                // Parse the data into Story objects
                Story parsedStory = new Story(webTitle, sectionName, webUrl,
                        authors, parsedPublicationDate, authorAvatarURL);
                storiesHolder.add(parsedStory);
            }
            return storiesHolder;
        } catch (JSONException e) {
            Log.e("QueryUtils", "Error while parsing JSON data", e);
        }
        return null;
    }

    public static class DownloadImageTask extends AsyncTask<String, Void, ImageView> {
        ImageView imageViewHolder;

        public DownloadImageTask(ImageView image) {
            this.imageViewHolder = image;
        }

        protected ImageView doInBackground(String... urls) {
            String urlDisplay = urls[0];
            try {
                InputStream in = new java.net.URL(urlDisplay).openStream();
                imageViewHolder.setImageBitmap(BitmapFactory.decodeStream(in));
                return imageViewHolder;
            } catch (Exception e) {
                Log.e("Error", e.getMessage());
                e.printStackTrace();
            }
            return null;
        }
    }
}
