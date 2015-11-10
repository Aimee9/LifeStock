package com.epicodus.lifestock.model;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.activeandroid.query.Select;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

/**
 * Created by oem on 10/27/15.
 */
@Table(name = "Sitings", id = "_id")
public class Siting extends Model {

    @Column(name = "Species")
    private String mSpecies;

    @Column(name = "Location")
    private String mLocation;

    @Column(name = "Image")
    private int mImage;

    @Column(name = "Notes")
    private String mNotes;

    @Column(name = "CreatedAt")
    private long mCreatedAt;

    public Siting() {
        super();
    }

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

    public long getCreatedAt() {
        return mCreatedAt;
    }

    public void setCreatedAt(long createdAt) {
        mCreatedAt = createdAt;
    }

    public String getFormattedTime() {
        SimpleDateFormat formatter = new SimpleDateFormat("EEEE, MMMM d 'at' h:mm");
        formatter.setTimeZone(TimeZone.getTimeZone("America/Los_Angeles"));
        return formatter.format(mCreatedAt);
    }

    public static List<Siting> all() {
        return new Select()
                .from(Siting.class)
                .execute();
    }

}