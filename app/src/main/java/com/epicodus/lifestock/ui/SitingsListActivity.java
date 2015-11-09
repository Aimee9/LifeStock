package com.epicodus.lifestock.ui;

import android.app.ListActivity;
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

public class SitingsListActivity extends ListActivity {

    private ArrayList<Siting> mSitings;
    private ListAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sitings_list);


        mSitings = (ArrayList)Siting.all();
        mAdapter = new ListAdapter(this, mSitings);
        setListAdapter(mAdapter);


    }
}
