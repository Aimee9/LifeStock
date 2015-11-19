package com.epicodus.lifestock.ui;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.epicodus.lifestock.R;
import com.epicodus.lifestock.adapters.ListAdapter;
import com.epicodus.lifestock.model.Siting;
import com.parse.FindCallback;
import com.parse.GetCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class SitingsListActivity extends ListActivity {

    private TextView mSpecies;
    private TextView mLocation;
    private TextView mNotes;
    private static List<Siting> mSitings;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sitings_list);

        mSpecies = (TextView) findViewById(R.id.speciesText);
//        mLocation = (TextView) findViewById(R.id.locationText);
//        mNotes = (TextView) findViewById(R.id.notesText);

        Siting.refreshSitingList(SitingsListActivity.this, new Runnable() {
            @Override
            public void run() {
                    mSitings = Siting.all();
            }
        });


    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();

        if (itemId == R.id.action_logout) {
            ParseUser.logOut();
            Intent intent = new Intent(SitingsListActivity.this, MainActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
}
