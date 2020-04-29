package com.example.myapplication.database;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Object {

    @PrimaryKey
    @ColumnInfo (name = "id")
    private int mId;

    @ColumnInfo (name = "title")
    private String mTitle;

    @ColumnInfo (name = "description")
    private String mDescription;

    @ColumnInfo (name = "schedule")
    private String mSchedule;

    @ColumnInfo (name = "address")
    private String mAddress;

    @ColumnInfo (name = "contacts")
    private String mContacts;


    public Object() {
    }

    public Object(int mId, String mTitle, String mDescription, String mSchedule, String mAddress, String mContacts) {
        this.mId = mId;
        this.mTitle = mTitle;
        this.mDescription = mDescription;
        this.mSchedule = mSchedule;
        this.mAddress = mAddress;
        this.mContacts = mContacts;
    }

    public int getMId() {
        return mId;
    }

    public void setMId(int mId) {
        this.mId = mId;
    }

    public String getMTitle() {
        return mTitle;
    }

    public void setMTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public String getMDescription() {
        return mDescription;
    }

    public void setMDescription(String mDescription) {
        this.mDescription = mDescription;
    }

    public String getMSchedule() {
        return mSchedule;
    }

    public void setMSchedule(String mSchedule) {
        this.mSchedule = mSchedule;
    }

    public String getMAddress() {
        return mAddress;
    }

    public void setMAddress(String mAddress) {
        this.mAddress = mAddress;
    }

    public String getMContacts() {
        return mContacts;
    }

    public void setMContacts(String mContacts) {
        this.mContacts = mContacts;
    }
}
