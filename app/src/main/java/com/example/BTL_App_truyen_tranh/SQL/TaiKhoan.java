package com.example.BTL_App_truyen_tranh.SQL;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class TaiKhoan {

    public static Boolean them_taikhoan(com.example.BTL_App_truyen_tranh.pojo.TaiKhoan tk, SQLite sqLiteDAO) {
        SQLiteDatabase MyDB = sqLiteDAO.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("tk", tk.getTk());
        contentValues.put("hoten", tk.getHoten());
        contentValues.put("mk", tk.getMk());
        long result = MyDB.insert("taikhoan", null, contentValues);
        if (result == -1)
            return false;
        else
            return true;
    }

    public static Boolean kiem_tra_tk(String tk, SQLite sqLiteDAO) {
        SQLiteDatabase MyDB = sqLiteDAO.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from taikhoan where tk = ?", new String[]{tk});
        if (cursor.getCount() > 0)
            return true;
        else
            return false;
    }

    public static String kiem_tra_dn(com.example.BTL_App_truyen_tranh.pojo.TaiKhoan tk, SQLite sqLiteDAO) {
        SQLiteDatabase MyDB = sqLiteDAO.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from taikhoan where tk = ? and mk = ?", new String[]{tk.getTk(), tk.getMk()});
        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
            com.example.BTL_App_truyen_tranh.pojo.TaiKhoan taiKhoan = new com.example.BTL_App_truyen_tranh.pojo.TaiKhoan();
            taiKhoan.setHoten(cursor.getString(2));
            cursor.close();
            return taiKhoan.getHoten();
        } else
            return "";
    }
    public static int kiem_tra_role(com.example.BTL_App_truyen_tranh.pojo.TaiKhoan tk, SQLite sqLiteDAO) {
        SQLiteDatabase MyDB = sqLiteDAO.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("SELECT role FROM taikhoan WHERE tk = ? AND mk = ?", new String[]{tk.getTk(), tk.getMk()});
        int role = 0;
        if (cursor.moveToFirst()) {
            role = cursor.getInt(0);
        }
        cursor.close();
        return role;
    }
}
