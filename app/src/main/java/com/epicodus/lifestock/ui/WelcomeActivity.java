package com.epicodus.lifestock.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.epicodus.lifestock.R;
import com.parse.ParseUser;

public class WelcomeActivity extends AppCompatActivity {

    private ImageButton mSheepButton;
    private ImageButton mBinoButton;
    private ImageButton mPointerButton;
    private TextView mUserName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        String username = getIntent().getStringExtra("Username");

        TextView inputName = (TextView)findViewById(R.id.userName);
        inputName.setText(username);

        mSheepButton = (ImageButton)findViewById(R.id.sheepButton);
        mBinoButton = (ImageButton)findViewById(R.id.binoButton);
        mPointerButton = (ImageButton)findViewById(R.id.pointerButton);

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
