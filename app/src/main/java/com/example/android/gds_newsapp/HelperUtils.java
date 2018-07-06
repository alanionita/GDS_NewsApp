package com.example.android.gds_newsapp;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class HelperUtils {
    public static String parseDateString(String date) {
        SimpleDateFormat inputFormat  = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        SimpleDateFormat outputFormat = new SimpleDateFormat("HH:mm dd MMMM yyyy");

        try {
            Date parsedDate = inputFormat.parse(date);
            String formattedDate = outputFormat.format(parsedDate);
            return formattedDate;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}
