package com.epicodus.lifestock.model;

/**
 * Created by oem on 10/27/15.
 */
public class Siting {
    private String mSpecies;
    private String mLocation;
    private int mImage;
    private String mNotes;

    public Siting(String species, String location, int image, String notes) {
        mSpecies = species;
        mLocation = location;
        mImage = image;
        mNotes = notes;
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
}
