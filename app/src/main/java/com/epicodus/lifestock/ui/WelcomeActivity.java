package com.epicodus.lifestock.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.epicodus.lifestock.R;

public class WelcomeActivity extends AppCompatActivity {

    private ImageButton mSheepButton;
    private ImageButton mBinoButton;
    private ImageButton mPointerButton;

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


}
