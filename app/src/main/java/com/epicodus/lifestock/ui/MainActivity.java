package com.epicodus.lifestock.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.epicodus.lifestock.R;
import com.parse.ParseObject;

public class MainActivity extends AppCompatActivity {

    private Button mEnterButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ParseObject testObject = new ParseObject("TestObject");
        testObject.put("foo", "bar");
        testObject.saveInBackground();

        mEnterButton = (Button) findViewById(R.id.enterButton);

        mEnterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText inputtedName = (EditText)findViewById(R.id.nameText);
                String username = inputtedName.getText().toString();
                Intent intent = new Intent(MainActivity.this, WelcomeActivity.class);
                intent.putExtra("Username", username);
                startActivity(intent);
            }
        });
    }


}
