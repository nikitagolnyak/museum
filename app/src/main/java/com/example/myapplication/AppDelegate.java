package com.example.myapplication;

import android.app.Application;

import androidx.room.Room;

import com.example.myapplication.database.MuseumDatabase;

public class AppDelegate extends Application {

    private MuseumDatabase mMuseumDatabase;



    @Override
    public void onCreate() {
        super.onCreate();

        mMuseumDatabase = Room.databaseBuilder(getApplicationContext(), MuseumDatabase.class, "museum_database")
                .allowMainThreadQueries()
                .build();

    }

    public MuseumDatabase getmMuseumDatabase() {
        return mMuseumDatabase;
    }

}
