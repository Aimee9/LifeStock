package com.epicodus.lifestock.ui;

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

        mSubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NewSitingActivity.this, SitingsListActivity.class);

            }
        });
    }


}

