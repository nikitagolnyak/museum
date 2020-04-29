package com.example.myapplication.database;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;


@Entity (foreignKeys = {
        @ForeignKey(entity = Object.class, parentColumns = "id", childColumns = "object_id"),
        @ForeignKey(entity = Group.class, parentColumns = "id", childColumns = "object_id")})
public class ObjectGroup {

    @PrimaryKey (autoGenerate = true)
    @ColumnInfo (name = "id")
    private int mId;

    @ColumnInfo (name = "object_id")
    private int mObjectId;

    @ColumnInfo (name = "group_id")
    private int mGroupId;

    public ObjectGroup() {
    }

    public ObjectGroup(int mId, int mObjectId, int mGroupId) {
        this.mId = mId;
        this.mObjectId = mObjectId;
        this.mGroupId = mGroupId;
    }

    public int getMId() {
        return mId;
    }

    public void setMId(int mId) {
        this.mId = mId;
    }

    public int getMObjectId() {
        return mObjectId;
    }

    public void setMObjectId(int mObjectId) {
        this.mObjectId = mObjectId;
    }

    public int getMGroupId() {
        return mGroupId;
    }

    public void setMGroupId(int mGroupId) {
        this.mGroupId = mGroupId;
    }
}
