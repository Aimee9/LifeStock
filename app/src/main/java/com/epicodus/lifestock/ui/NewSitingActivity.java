package com.epicodus.lifestock.ui;

import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.epicodus.lifestock.R;
import com.epicodus.lifestock.adapters.ListAdapter;
import com.epicodus.lifestock.model.Siting;
import com.parse.ParseObject;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class NewSitingActivity extends AppCompatActivity {

    @Bind(R.id.speciesLabel) EditText mSpecies;
    @Bind(R.id.locationLabel) EditText mLocation;
    @Bind(R.id.notesLabel) EditText mNotes;
    @Bind(R.id.submitButton) Button mSubmitButton;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_siting);
        ButterKnife.bind(this);



        mSubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ParseObject newListing = new ParseObject("NewListing");
                String species = mSpecies.getText().toString();
                String location = mLocation.getText().toString();
                String notes = mNotes.getText().toString();
                newListing.put("species", species);
                newListing.put("location", location);
                newListing.put("notes", notes);
                newListing.saveInBackground();

                Intent intent = new Intent(NewSitingActivity.this, SitingsListActivity.class);
                startActivity(intent);
//                Bundle bundle = new Bundle();
//                bundle.putString("species", mSpecies.getText().toString());
//                bundle.putString("location", mLocation.getText().toString());
//                bundle.putString("notes", mNotes.getText().toString());
//                Intent intent = new Intent(NewSitingActivity.this, SitingsListActivity.class);
//                intent.putExtras(bundle);
//                startActivity(intent);
            }
        });
    }


}

