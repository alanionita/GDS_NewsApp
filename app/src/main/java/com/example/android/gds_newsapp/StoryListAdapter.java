package com.example.android.gds_newsapp;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.icu.text.Normalizer;
import android.media.Image;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.cert.PolicyQualifierInfo;
import java.util.ArrayList;

import static com.example.android.gds_newsapp.MainActivity.LOG_TAG;

/**
 * Created by alanionita on 02/07/2018.
 */

public class StoryListAdapter extends ArrayAdapter<Story> {
    public StoryListAdapter(@NonNull Context context, ArrayList<Story> stories) {
        super(context, 0, stories);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        TextView itemTitle;
        TextView itemSection;
        TextView itemAuthor;
        TextView itemPublishDate;
        ImageView authorAvatar;

        // Get current story
        final Story currentStory = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent,
                    false);

            // Find views from list_item layout
            itemTitle = (TextView) convertView.findViewById(R.id.web_title);
            itemSection = (TextView) convertView.findViewById(R.id.section_name);
            itemAuthor = (TextView) convertView.findViewById(R.id.authors);
            itemPublishDate = (TextView) convertView.findViewById(R.id.data_published);
            authorAvatar = (ImageView) convertView.findViewById(R.id.avatar_image);

            if (currentStory != null) {
                ArrayList<String> authorsHolder = currentStory.getAuthors();
                String datePubHolder = currentStory.getWebPublicationDate();

                itemTitle.setText(currentStory.getWebTitle());
                itemSection.setText(currentStory.getSectionName());
                if (authorsHolder != null) {
                    if (authorsHolder.size() > 0) {
                        String authorsString = String.join(", ", authorsHolder);
                        itemAuthor.setText(authorsString);
                        Log.i("outside if authorAvatar", currentStory.getAuthorAvatar());
                        if (currentStory.getAuthorAvatar() != null ||
                                currentStory.getAuthorAvatar().length() > 0) {
                            new QueryUtils.DownloadImageTask(authorAvatar).execute(
                                    currentStory.getAuthorAvatar()
                            );
                        }
                    }
                }

                if (datePubHolder != null) {
                    if (datePubHolder.length() > 0) {
                        itemPublishDate.setText(datePubHolder);
                    }
                }

                // Set onClickListener that triggers a browser intent with each story url
                convertView.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        // Trigger a browser intent with the stored URL
                        getContext()
                                .startActivity(new Intent(Intent.ACTION_VIEW)
                                        .setData(Uri.parse(currentStory.getWebUrl())));
                    }
                });
            }
        }
        return convertView;
    }
}