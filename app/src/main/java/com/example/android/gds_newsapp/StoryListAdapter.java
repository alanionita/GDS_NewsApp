package com.example.android.gds_newsapp;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by alanionita on 02/07/2018.
 */

public class StoryListAdapter extends ArrayAdapter<Story> {
    StoryListAdapter(@NonNull Context context, ArrayList<Story> stories) {
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
            itemTitle = convertView.findViewById(R.id.TextView_title);
            itemSection = convertView.findViewById(R.id.TextView_section_name);
            itemAuthor = convertView.findViewById(R.id.TextView_authors);
            itemPublishDate = convertView.findViewById(R.id.TextView_data_published);
            authorAvatar = convertView.findViewById(R.id.ImageView_avatar_image);

            if (currentStory != null) {
                ArrayList<String> authorsHolder = currentStory.getAuthors();
                String datePubHolder = currentStory.getWebPublicationDate();
                Log.i("title", currentStory.getWebTitle());
                itemTitle.setText(currentStory.getWebTitle());
                itemSection.setText(currentStory.getSectionName());
                if (authorsHolder != null) {
                    if (authorsHolder.size() > 0) {
                        String authorsString = TextUtils.join(", ", authorsHolder);
                        itemAuthor.setText(authorsString);
                        if (currentStory.getAuthorAvatar() != null) {
                            authorAvatar.setImageBitmap(currentStory.getAuthorAvatar());
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