package com.epicodus.lifestock.ui;

import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.epicodus.lifestock.R;
import com.epicodus.lifestock.adapters.ListAdapter;
import com.epicodus.lifestock.model.Siting;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class SitingsListActivity extends ListActivity {

    @Bind(R.id.speciesText)TextView mSpeciesText;
    @Bind(R.id.locationText)TextView mLocationText;
    @Bind(R.id.notesText) TextView mNotes;
    private ArrayList<Siting> mSitings;
    private ListAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sitings_list);
        ButterKnife.bind(this);

        Intent intent = this.getIntent();
        Bundle bundle = intent.getExtras();
        final String species = bundle.getString("species");
        final String location = bundle.getString("location");
        final String notes = bundle.getString("notes");

        Siting thisSiting = new Siting(species, location, notes);
        mSitings.add(thisSiting);




        mSitings = (ArrayList)Siting.all();
        mAdapter = new ListAdapter(this, mSitings);
        setListAdapter(mAdapter);


    }
}
