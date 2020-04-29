package com.example.myapplication.database;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;

import androidx.room.Room;

import java.net.URI;

public class MuseumProvider extends ContentProvider {


    private static final String TAG = MuseumProvider.class.getSimpleName();
    private static final String AUTHORITY = "com.example.myapplication.museumprovider";
    private static final String TABLE_GROUP = "group";


    private static final UriMatcher URI_MATCHER = new UriMatcher(UriMatcher.NO_MATCH);

    private static final int GROUP_TABLE_CODE = 100;

    private static final int GROUP_ROW_CODE = 101;

    static {
        URI_MATCHER.addURI(AUTHORITY, TABLE_GROUP, GROUP_TABLE_CODE);
        URI_MATCHER.addURI(AUTHORITY, TABLE_GROUP + "/*", GROUP_ROW_CODE);

    }

    private ObjectDao mObjectDao;


    public MuseumProvider() {
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        // Implement this to handle requests to delete one or more rows.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public String getType(Uri uri) {
        switch (URI_MATCHER.match(uri)) {
            case GROUP_TABLE_CODE:
                return "vnd.android.cursor.dir/" + AUTHORITY + "." + TABLE_GROUP;
            case  GROUP_ROW_CODE:
                return "vnd.android.cursor.item/" + AUTHORITY + "." + TABLE_GROUP;
            default:
                throw new UnsupportedOperationException("not yet implemented");
        }
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
        // TODO: Implement this to handle requests to insert a new row.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public boolean onCreate() {
        if(getContext() != null) {
            mObjectDao = Room.databaseBuilder(getContext().getApplicationContext(), MuseumDatabase.class, "museum_database")
                    .build()
                    .getObjectDao();
            return true;
        }
        return false;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection,
                        String[] selectionArgs, String sortOrder) {

        int code = URI_MATCHER.match(uri);

        if (code != GROUP_ROW_CODE && code != GROUP_TABLE_CODE) return null;

        Cursor cursor;

        if (code == GROUP_TABLE_CODE) {
            cursor = mObjectDao.getGroupsCursor();
        } else {
            cursor = mObjectDao.getGroupWithIdCursor((int) ContentUris.parseId(uri));
        }
        return cursor;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection,
                      String[] selectionArgs) {
        // TODO: Implement this to handle requests to update one or more rows.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
