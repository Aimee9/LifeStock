package com.epicodus.lifestock.model;

import com.epicodus.lifestock.R;

import java.util.ArrayList;

/**
 * Created by oem on 10/27/15.
 */
public class SitingLibrary {
    private ArrayList<Siting>mSitings;

    public SitingLibrary() {
        setAllSitings();
    }

    public ArrayList<Siting>getSitings() {
        return mSitings;
    }

    public void setAllSitings() {
        mSitings = new ArrayList<>();

        mSitings.add(new Siting(
                "Mountain beaver",
                "Oregon",
                R.drawable.mountain_beaver,
                "This guy was a cutie.  He forgot about me and started washing himself."
        ));

        mSitings.add(new Siting(
                "Gray bat",
                "Oregon",
                R.drawable.bat,
                "This poor guy got stuck in our flue.  We got him out but he was too weak to fly immediately.  He rested in a plastic tub for a bit.  He then started getting restless so we took him out on the deck and he flew off into the woods."
        ));
    }

    public Siting nextSiting(Siting currentSiting) {
        int index = mSitings.indexOf(currentSiting);
        if (index == mSitings.size() - 1) {
            return mSitings.get(0);
        }else {
            return mSitings.get(index + 1);
        }
    }
}
