package com.epicodus.lifestock.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.epicodus.lifestock.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class NewSitingActivity extends AppCompatActivity {

    @Bind(R.id.speciesLabel) EditText mSpecies;
    @Bind(R.id.locationLabel) EditText mLocation;
    @Bind(R.id.submitButton) EditText mSubmitButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_siting);
        ButterKnife.bind(this);
    }


}

//
//mSpecies = (TextView) findViewById(R.id.speciesText);
//        mLocation = (TextView) findViewById(R.id.locationText);
//        mImage = (ImageView) findViewById(R.id.animalImage);
//        mNotes = (TextView) findViewById(R.id.notesText);
//        mButton = (Button) findViewById(R.id.nextButton);
