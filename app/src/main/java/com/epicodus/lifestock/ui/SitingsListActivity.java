package com.epicodus.lifestock.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.epicodus.lifestock.R;
import com.epicodus.lifestock.model.Siting;
import com.epicodus.lifestock.model.SitingLibrary;

public class SitingsListActivity extends AppCompatActivity {
    private TextView mSpecies;
    private TextView mLocation;
    private ImageView mImage;
    private TextView mNotes;
    private Button mButton;

    private SitingLibrary mSitingLibrary;
    private Siting mCurrentSiting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sitings_list);

        mSpecies = (TextView)findViewById(R.id.speciesText);
        mLocation = (TextView)findViewById(R.id.locationText);
        mImage = (ImageView)findViewById(R.id.animalImage);
        mNotes = (TextView)findViewById(R.id.notesText);
        mButton = (Button)findViewById(R.id.nextButton);
        mSitingLibrary = new SitingLibrary();
        mCurrentSiting = mSitingLibrary.getSitings().get(0);

        setLayoutContent();

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCurrentSiting = mSitingLibrary.nextSiting(mCurrentSiting);
                setLayoutContent();
            }
        });
    }

    private void setLayoutContent() {
        mSpecies.setText(mCurrentSiting.getSpecies());
        mLocation.setText(mCurrentSiting.getLocation());
        mImage.setImageResource(mCurrentSiting.getImage());
        mNotes.setText(mCurrentSiting.getNotes());
    }


}
