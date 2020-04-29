package com.example.myapplication.database;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity
public class Group {

    @PrimaryKey
    @ColumnInfo (name = "id")
    private int mId;

    @ColumnInfo (name = "name")
    private String mName;

    @Ignore
    public Group() {
    }

    public Group(int mId, String mName) {
        this.mId = mId;
        this.mName = mName;
    }

    public int getMId() {
        return this.mId;
    }

    public void setmId(int mId) {
        this.mId = mId;
    }

    public String getMName() {
        return this.mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    @Override
    public String toString() {
        return "Group{" +
                "mId=" + mId +
                ", mName='" + mName + '}';
    }
}
