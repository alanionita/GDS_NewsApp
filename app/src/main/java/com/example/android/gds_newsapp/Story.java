package com.example.android.gds_newsapp;

import android.graphics.Bitmap;

import java.util.ArrayList;

/**
 * Created by alanionita on 02/07/2018.
 */

public class Story {
    private String webTitle;
    private String sectionName;
    private String webUrl;
    private ArrayList<String> authors;
    private String webPublicationDate;
    private Bitmap authorAvatar;

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
                 String webPublicationDate, Bitmap downloadedAuthorAvatar) {
        this.webTitle = title;
        this.sectionName = section;
        this.authors = authors;
        this.webPublicationDate = webPublicationDate;
        this.webUrl = webUrl;
        this.authorAvatar = downloadedAuthorAvatar;
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

    public Bitmap getAuthorAvatar() {
        return authorAvatar;
    }
}
