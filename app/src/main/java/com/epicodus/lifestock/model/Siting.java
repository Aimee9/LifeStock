package com.epicodus.lifestock.model;

import android.app.Activity;
import android.util.Log;
import android.widget.ArrayAdapter;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.activeandroid.query.Select;
import com.epicodus.lifestock.R;
import com.parse.FindCallback;
import com.parse.ParseClassName;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

/**
 * Created by oem on 10/27/15.
 */
@ParseClassName("Siting")
public class Siting extends ParseObject {


    private String mSpecies;
    private String mLocation;
    private int mImage;
    private String mNotes;
    private long mCreatedAt;
    private ParseObject newListing;
    private static List<Siting> mSitings;
    private ArrayAdapter<Siting> mAdapter;


    public Siting(String species, String location, String notes) {
        mSpecies = species;
        mLocation = location;
        mNotes = notes;
        mCreatedAt = new Date().getTime();
    }


    public String getSpecies() {
        return mSpecies;
    }

    public void setSpecies(String mSpecies) {
        this.mSpecies = mSpecies;
    }

    public String getLocation() {
        return mLocation;
    }

    public void setLocation(String mLocation) {
        this.mLocation = mLocation;
    }

    public int getImage() {
        return mImage;
    }

    public void setImage(int mImage) {
        this.mImage = mImage;
    }

    public String getNotes() {
        return mNotes;
    }

    public void setNotes(String mNotes) {
        this.mNotes = mNotes;
    }


    public String getFormattedTime() {
        SimpleDateFormat formatter = new SimpleDateFormat("EEEE, MMMM d 'at' h:mm");
        formatter.setTimeZone(TimeZone.getTimeZone("America/Los_Angeles"));
        return formatter.format(mCreatedAt);
    }

    public static List<Siting> all() {
        return mSitings;
    }

    @Override
    public String toString() {
        return this.getSpecies();
    }



    public static void refreshSitingList(final Activity context, final Runnable runnable) {
        ParseQuery<Siting> query = ParseQuery.getQuery("NewListing");
        query.findInBackground(new FindCallback<Siting>() {
            @Override
            public void done(List<Siting> newListings, ParseException e) {
                if (e == null) {
                    mSitings = newListings;
                    context.runOnUiThread(runnable);


//                    for (ParseObject newListing : newListings) {
//                        String species = newListing.getString("species");
//                        mSitings.add(species);
//                        mAdapter.notifyDataSetChanged();

                }else {
                    Log.d("parse", "failed!" + e);
                }
            }
        });
    }
}