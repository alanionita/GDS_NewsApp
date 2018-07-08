package com.example.android.gds_newsapp;

import android.graphics.Bitmap;

import org.json.JSONArray;

import java.util.ArrayList;

/**
 * Created by alanionita on 02/07/2018.
 */

public class Story {
    final String webTitle;
    final String sectionName;
    final String webUrl;
    final ArrayList<String> authors;
    final String webPublicationDate;
    final String authorAvatar;

    public Story(String title, String section, String url) {
        this.webTitle = title;
        this.sectionName = section;
        this.webUrl = url;
        this.authors = null;
        this.webPublicationDate = null;
        this.authorAvatar = null;
    }

    public Story(String title, String section, String webUrl, ArrayList<String> authorTags ) {
        this.webTitle = title;
        this.sectionName = section;
        this.webUrl = webUrl;
        this.authors = authorTags;
        this.webPublicationDate = null;
        this.authorAvatar = null;
    }

    public Story(String title, String section, String webUrl, ArrayList<String> authors,
                 String webPublicationDate, String avatarURL) {
        this.webTitle = title;
        this.sectionName = section;
        this.authors = authors;
        this.webPublicationDate = webPublicationDate;
        this.webUrl = webUrl;
        this.authorAvatar = avatarURL;
    }

    public String getWebTitle() {
        return webTitle;
    }

    public String getSectionName() {
        return sectionName;
    }

    public String getWebUrl() {
        return webUrl;
    }

    public ArrayList<String> getAuthors() {
        return authors;
    }

    public String getWebPublicationDate() {
        return webPublicationDate;
    }

    public String getAuthorAvatar() { return authorAvatar; }
}
