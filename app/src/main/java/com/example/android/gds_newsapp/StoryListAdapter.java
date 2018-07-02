package com.example.android.gds_newsapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by alanionita on 02/07/2018.
 */

public class StoryListAdapter extends ArrayAdapter<Story> {
    public StoryListAdapter(@NonNull Context context, ArrayList<Story> stories){
        super(context, 0, stories);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        TextView itemTitle;
        TextView itemSection;
        TextView itemAuthor;
        TextView itemPublishDate;

        // Get current story
        final Story currentStory = getItem(position);

        if(convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent,
                    false);

            // Find views from list_item layout
            itemTitle = (TextView) convertView.findViewById(R.id.web_title);
            itemSection = (TextView) convertView.findViewById(R.id.section_name);
            itemAuthor = (TextView) convertView.findViewById(R.id.authors);
            itemPublishDate = (TextView) convertView.findViewById(R.id.data_published);

            if (currentStory != null) {
                ArrayList<String> authorsHolder = currentStory.getAuthors();
                String datePubHolder = currentStory.getWebPublicationDate();

                itemTitle.setText(currentStory.getWebTitle());
                itemSection.setText(currentStory.getSectionName());
                if(authorsHolder != null) {
                    if (authorsHolder.size() > 0){
                        String authorsString = String.join(",", authorsHolder);
                        itemAuthor.setText(authorsString);
                    }
                }

                if(datePubHolder != null) {
                    if (datePubHolder.length() > 0){
                        itemPublishDate.setText(datePubHolder);
                    }
                }
            }
        }
        return convertView;
    }
}
