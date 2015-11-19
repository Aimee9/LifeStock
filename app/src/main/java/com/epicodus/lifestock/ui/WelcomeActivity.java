package com.epicodus.lifestock.ui;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.epicodus.lifestock.R;
import com.parse.ParseUser;

import java.util.List;

public class WelcomeActivity extends AppCompatActivity {

    private ImageButton mSheepButton;
    private ImageButton mBinoButton;
    private ImageButton mPointerButton;
    private ImageButton mTernButton;
    private TextView mUserName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        String username = getIntent().getStringExtra("Username");


        mSheepButton = (ImageButton)findViewById(R.id.batButton);
        mBinoButton = (ImageButton)findViewById(R.id.ocelotButton);
        mPointerButton = (ImageButton)findViewById(R.id.sageButton);
        mTernButton = (ImageButton)findViewById(R.id.ternButton);

        mSheepButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(WelcomeActivity.this, SitingsListActivity.class);
                startActivity(intent);
            }
        });

        mBinoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(WelcomeActivity.this, NewSitingActivity.class);
                startActivity(intent);
            }
        });

        mPointerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(WelcomeActivity.this, OtherPeopleActivity.class);
                startActivity(intent);
            }
        });

        mTernButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {Uri websiteLink = Uri.parse(getString(R.string.website));
                Intent websiteIntent = new Intent(Intent.ACTION_VIEW, websiteLink);
                if (isIntentSafe(websiteIntent)) {
                    startActivity(websiteIntent);
                }

            }
        });

    }

    private boolean isIntentSafe(Intent intent) {
        PackageManager packageManager = getPackageManager();
        List activities = packageManager.queryIntentActivities(intent, PackageManager.MATCH_DEFAULT_ONLY);
        return activities.size() > 0;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_welcome, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();

        if (itemId == R.id.action_logout) {
            ParseUser.logOut();
            Intent intent = new Intent(WelcomeActivity.this, MainActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
}
