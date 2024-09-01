package com.example.quote_of_the_day_encriptix;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.ParcelUuid;
import android.provider.ContactsContract;

import androidx.annotation.Nullable;

public class FavDB extends SQLiteOpenHelper {
    private static int DB_VERSION = 1;
    private static String DATA_NAME ="quote";
    private static String TABLE_NAME ="FAV";
    private static String ID ="id";
    private static String text ="text";
    private static String author ="author";
    private static String FAV_STATUS="favstatus";
    private static String CREATE_TABLE="CREATE TABLE "+ TABLE_NAME +"("+ ID +
            " TEXT," +text+" TEXT,"+author+" TEXT,"+FAV_STATUS +" TEXT)";

    public FavDB(@Nullable Context context){
        super(context,DATA_NAME,null,DB_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
