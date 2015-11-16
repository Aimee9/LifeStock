package com.epicodus.lifestock;


import android.app.Application;

import com.parse.Parse;

/**
 * Created by oem on 11/16/15.
 */
public class MyApplication extends Application {
    public void onCreate() {
        Parse.initialize(this, "8bu2XOku960ymX2biauSMovo2TrRcF7iGEw448D9", "Uaa7xS0rSU9MiAJFNqPANSvSeG7sw042FF42wzU0");
    }
}
