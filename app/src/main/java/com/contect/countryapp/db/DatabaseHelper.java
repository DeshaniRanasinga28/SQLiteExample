package com.contect.countryapp.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseHelper  extends SQLiteOpenHelper {
    public static final String TAG = DatabaseHelper.class.getSimpleName();

//    table name
    public static final String TABLE_NAME = "COUNTRIES";

//    table columns
    public static final String _ID = "_id";
    public static final String SUBJECT = "subject";
    public static final String DESC = "description";

//    database information
    public static final String DB_NAME = "JOUENALDEV_COUNTRIES.DB";

//    database version
    public static final int DB_VERSION = 1;

//    create table query
     private static final String CREATE_TABLE = "create table " + TABLE_NAME +
        "(" + _ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + SUBJECT + " TEXT NOT NULL, "
        + DESC + " TEXT);";


    public DatabaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.d(TAG, "onCreate SQL: " + CREATE_TABLE);
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        Log.d(TAG,"onUpdate SQL: " + db);
        onCreate(db);
    }
}
