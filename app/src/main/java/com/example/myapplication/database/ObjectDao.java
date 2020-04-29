package com.example.myapplication.database;

import android.database.Cursor;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;


@Dao
public interface ObjectDao {

    @Insert (onConflict = OnConflictStrategy.REPLACE)
    void insertObject(List<Object> objects);

    @Insert (onConflict = OnConflictStrategy.REPLACE)
    void insertGroup(List<Group> groups);

    @Insert (onConflict = OnConflictStrategy.REPLACE)
    void setLinksObjectGroup(List<ObjectGroup> linksObjectGroup);

    @Query("select * from `group`")
    List<Group> getGroups();

    @Query("select * from `group`")
    Cursor getGroupsCursor();

    @Query("select * from `group` where id = :groupId")
    Cursor getGroupWithIdCursor(int groupId);

    @Query("select * from object")
    List<Object> getObjects();

    @Query("select * from object inner join objectgroup on object.id = objectgroup.object_id where group_id = :groupId")
    List<Object> getObjectsFromGroup(int groupId);



}
