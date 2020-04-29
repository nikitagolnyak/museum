package com.example.myapplication.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;


@Database(entities = {Group.class, Object.class, ObjectGroup.class}, version = 1)
public abstract class MuseumDatabase extends RoomDatabase {

    public abstract ObjectDao getObjectDao();

}
