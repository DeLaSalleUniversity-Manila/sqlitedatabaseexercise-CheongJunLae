package com.example.student.teaapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

class TeaDatabaseHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "teadata"; // the name of our database
    private static final int DB_VERSION = 2; // the version of the database

    TeaDatabaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        updateMyDatabase(db, 0, DB_VERSION);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        updateMyDatabase(db, oldVersion, newVersion);
    }

    private void updateMyDatabase(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion < 1) {
            db.execSQL("CREATE TABLE TEA (_id INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + "NAME TEXT, "
                    + "DESCRIPTION TEXT, "
                    + "IMAGE_RESOURCE_ID INTEGER);");
            insertTea(db, "Longjing", "Maybe the most well-known green tea in China", R.drawable.longjing);
            insertTea(db, "Maofeng", "Meaning: furry peak",
                    R.drawable.maofeng);
        }
        insertTea(db, "Biluochun", "A Chinese famous tea also known as Green Snail Spring", R.drawable.biluochun);
        if (oldVersion < 2) {
            db.execSQL("ALTER TABLE DRINK ADD COLUMN FAVORITE NUMERIC;");
        }
    }

    private static void insertTea(SQLiteDatabase db, String name,
                                  String description, int resourceId) {
        ContentValues teaValues = new ContentValues();
        teaValues.put("NAME", name);
        teaValues.put("DESCRIPTION", description);
        teaValues.put("IMAGE_RESOURCE_ID", resourceId);
        db.insert("DRINK", null, teaValues);
    }
}