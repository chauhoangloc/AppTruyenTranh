package com.example.BTL_App_truyen_tranh.DAO;

import static com.example.BTL_App_truyen_tranh.GUI.QuanLyTruyen.HomeQuanLy.sqLiteDAO;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

import com.example.BTL_App_truyen_tranh.DTO.TaiKhoan;

public class KieuTruyen {
    public static Boolean them_kieutruyen(String tenkt) {
        SQLiteDatabase MyDB = sqLiteDAO.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("tenkt", tenkt);
        long result = MyDB.insert("kieutruyen", null, contentValues);
        if (result == -1)
            return false;
        else
            return true;
    }
}
