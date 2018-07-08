package com.example.android.gds_newsapp;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    /** Tag for the log messages */
    public static final String LOG_TAG = MainActivity.class.getSimpleName();

    /** URL to query the Guardian API for Brexit News articles */
    private static final String GUARDIAN_REQUEST_URL = "https://content.guardianapis.com/search?show-tags=contributor&show-elements=image&q=brexit&api-key=3d9afde5-908f-407e-a77c-c81994fc9bee";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Kick off an {@link AsyncTask} to perform the network request
        StoriesAsyncTask task = new StoriesAsyncTask();
        task.execute();
    }

    protected void updateUI (ArrayList<Story> stories){

        // Find the listView in the layout
        ListView storiesList = (ListView) findViewById(R.id.list);

        // Create a new StoryListAdapter
        StoryListAdapter adapter = new StoryListAdapter(this, stories);

        // Set adapter on ListView
        storiesList.setAdapter(adapter);
    }

    /**
     * {@link AsyncTask} to perform the network request on a background thread, and then
     * update the UI with the Brexit stories in the response.
     */
    private class StoriesAsyncTask extends AsyncTask<URL, Void, ArrayList<Story>> {

        @Override
        protected ArrayList<Story> doInBackground(URL... urls) {
            // Create URL object
            URL url = createUrl(GUARDIAN_REQUEST_URL);

            // Perform HTTP request to the URL and receive a JSON response back
            String jsonResponse = "";
            try {
                jsonResponse = makeHttpRequest(url);
            } catch (IOException e) {
                Log.e("IOException","IOException logged!", e);
            }
            return QueryUtils.extractStory(jsonResponse);
        }

        /**
         * Update the screen with the given earthquake (which was the result of the
         * {@link StoriesAsyncTask}).
         */
        @Override
        protected void onPostExecute(ArrayList<Story> stories) {
            if (stories == null || stories.size() == 0) {
                return;
            }
            // Update the UI
            updateUI(stories);
        }

        /**
         * Make an HTTP request to the given URL and return a String as the response.
         */
        private String makeHttpRequest(URL url) throws IOException {
            String jsonResponse = "";
            HttpURLConnection urlConnection = null;
            InputStream inputStream = null;

            if(url == null) {
                return jsonResponse;
            }

            try {
                urlConnection = (HttpURLConnection) url.openConnection();
                urlConnection.setRequestMethod("GET");
                urlConnection.setReadTimeout(10000 /* milliseconds */);
                urlConnection.setConnectTimeout(15000 /* milliseconds */);
                urlConnection.connect();
                if (urlConnection.getResponseCode() == 200) {
                    inputStream = urlConnection.getInputStream();
                    jsonResponse = readFromStream(inputStream);
                } else {
                    Log.e(LOG_TAG, "Error response code " + urlConnection.getResponseCode());
                }
            } catch (IOException e) {
                Log.e("IOException", "IOException thrown!", e);
            } finally {
                if (urlConnection != null) {
                    urlConnection.disconnect();
                }
                if (inputStream != null) {
                    // function must handle java.io.IOException here
                    inputStream.close();
                }
            }
            return jsonResponse;
        }

        /**
         * Convert the {@link InputStream} into a String which contains the
         * whole JSON response from the server.
         */
        private String readFromStream(InputStream inputStream) throws IOException {
            StringBuilder output = new StringBuilder();
            if (inputStream != null) {
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream, Charset.forName("UTF-8"));
                BufferedReader reader = new BufferedReader(inputStreamReader);
                String line = reader.readLine();
                while (line != null) {
                    output.append(line);
                    line = reader.readLine();
                }
            }
            return output.toString();
        }
    }

    /**
     * Returns new URL object from the given string URL.
     */
    public URL createUrl(String stringUrl) {
        URL url = null;
        try {
            url = new URL(stringUrl);
        } catch (MalformedURLException exception) {
            Log.e(LOG_TAG, "Error with creating URL", exception);
            return null;
        }
        return url;
    }
}
