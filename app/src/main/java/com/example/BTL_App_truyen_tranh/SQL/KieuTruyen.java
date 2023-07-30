package com.example.BTL_App_truyen_tranh.SQL;

import static com.example.BTL_App_truyen_tranh.Activity.QuanLyTruyen.HomeQuanLy.sqLite;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

public class KieuTruyen {
    public static Boolean them_kieutruyen(String tenkt) {
        SQLiteDatabase MyDB = sqLite.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("tenkt", tenkt);
        long result = MyDB.insert("kieutruyen", null, contentValues);
        if (result == -1)
            return false;
        else
            return true;
    }
}
