package com.example.testofmyskills;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "bws_coworkerDb";
    public static final String TABLE = "bws_coworkers";

    public static final String KEY_ID = "_id";
    public static final String KEY_NAME = "name";
    public static final String KEY_AGE = "age";
    public static final String KEY_PHONE = "phone";
    public static final String KEY_GENDER = "gender";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE + "(" + KEY_ID + " integer primary key,"
                + KEY_NAME + " text," + KEY_AGE + " integer,"
                + KEY_PHONE + " text," + KEY_GENDER + " text" + ")" );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists " + TABLE);

        onCreate(db);
    }
}

