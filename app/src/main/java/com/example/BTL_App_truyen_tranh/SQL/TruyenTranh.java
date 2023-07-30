package com.example.BTL_App_truyen_tranh.SQL;

import static com.example.BTL_App_truyen_tranh.Activity.QuanLyTruyen.HomeQuanLy.sqLite;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class TruyenTranh {
    public static Boolean them_truyentranh(com.example.BTL_App_truyen_tranh.pojo.TruyenTranh truyenTranh, SQLite sqLiteDAO) {
        SQLiteDatabase MyDB = sqLiteDAO.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("tenTruyen", truyenTranh.getTenTruyen());
        contentValues.put("ngayDang", truyenTranh.getNgayDang());
        contentValues.put("tinhTrang", truyenTranh.getTinhTrang());
        contentValues.put("theLoai", truyenTranh.getTheLoai());
        contentValues.put("gioiThieu", truyenTranh.getGioiThieu());
        contentValues.put("img", truyenTranh.getImg());
        long result = MyDB.insert("truyentranh", null, contentValues);
        if (result == -1)
            return false;
        else
            return true;
    }
    public static Boolean sua_truyentranh(com.example.BTL_App_truyen_tranh.pojo.TruyenTranh truyenTranh, SQLite sqLiteDAO) {
        SQLiteDatabase MyDB = sqLiteDAO.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("tenTruyen", truyenTranh.getTenTruyen());
        contentValues.put("ngayDang", truyenTranh.getNgayDang());
        contentValues.put("tinhTrang", truyenTranh.getTinhTrang());
        contentValues.put("theLoai", truyenTranh.getTheLoai());
        contentValues.put("gioiThieu", truyenTranh.getGioiThieu());
        contentValues.put("img", truyenTranh.getImg());
        long result = MyDB.update("truyentranh",contentValues,"idtt=?" , new String[]{String.valueOf(truyenTranh.getIdTruyen())});
        if (result == -1)
            return false;
        else
            return true;
    }
    public static boolean xoa_truyentranh(int idtt) {
        SQLiteDatabase MyDB = sqLite.getWritableDatabase();
        long result = MyDB.delete("truyentranh","idtt=?" , new String[]{String.valueOf(idtt)});
        if (result == -1)
            return false;
        else
            return true;
    }
    public static List<com.example.BTL_App_truyen_tranh.pojo.TruyenTranh> getall_tt(SQLite sqLiteDAO) {
        List<com.example.BTL_App_truyen_tranh.pojo.TruyenTranh> sanphams = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = sqLiteDAO.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("select * From truyentranh", null);
        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                com.example.BTL_App_truyen_tranh.pojo.TruyenTranh truyenTranh = new com.example.BTL_App_truyen_tranh.pojo.TruyenTranh();
                truyenTranh.setIdTruyen(cursor.getInt(0));
                truyenTranh.setTenTruyen(cursor.getString(1));
                truyenTranh.setNgayDang(cursor.getString(2));
                truyenTranh.setTinhTrang(cursor.getString(3));
                truyenTranh.setTheLoai(cursor.getString(4));
                truyenTranh.setGioiThieu(cursor.getString(5));
                truyenTranh.setImg(cursor.getBlob(6));
                sanphams.add(truyenTranh);
                cursor.moveToNext();
            }
            cursor.close();
        }
        return sanphams;
    }
    public static List<com.example.BTL_App_truyen_tranh.pojo.TruyenTranh> timkiem_tt(String tenTruyen, SQLite sqLiteDAO) {
        List<com.example.BTL_App_truyen_tranh.pojo.TruyenTranh> sanphams = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = sqLiteDAO.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("select * From truyentranh where tenTruyen LIKE ?", new String[]{"%" + tenTruyen + "%"});
        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                com.example.BTL_App_truyen_tranh.pojo.TruyenTranh truyenTranh = new com.example.BTL_App_truyen_tranh.pojo.TruyenTranh();
                truyenTranh.setIdTruyen(cursor.getInt(0));
                truyenTranh.setTenTruyen(cursor.getString(1));
                truyenTranh.setNgayDang(cursor.getString(2));
                truyenTranh.setTinhTrang(cursor.getString(3));
                truyenTranh.setTheLoai(cursor.getString(4));
                truyenTranh.setGioiThieu(cursor.getString(5));
                truyenTranh.setImg(cursor.getBlob(6));
                sanphams.add(truyenTranh);
                cursor.moveToNext();
            }
            cursor.close();
        }
        return sanphams;
    }
    public static List<com.example.BTL_App_truyen_tranh.pojo.TruyenTranh> gettruyentranhtl(String tentl, SQLite sqLiteDAO) {
        List<com.example.BTL_App_truyen_tranh.pojo.TruyenTranh> sanphams = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = sqLiteDAO.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("select * From truyentranh where theLoai= ?", new String[]{tentl });
        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                com.example.BTL_App_truyen_tranh.pojo.TruyenTranh truyenTranh = new com.example.BTL_App_truyen_tranh.pojo.TruyenTranh();
                truyenTranh.setIdTruyen(cursor.getInt(0));
                truyenTranh.setTenTruyen(cursor.getString(1));
                truyenTranh.setNgayDang(cursor.getString(2));
                truyenTranh.setTinhTrang(cursor.getString(3));
                truyenTranh.setTheLoai(cursor.getString(4));
                truyenTranh.setGioiThieu(cursor.getString(5));
                truyenTranh.setImg(cursor.getBlob(6));
                sanphams.add(truyenTranh);
                cursor.moveToNext();
            }
            cursor.close();
        }
        return sanphams;
    }
    public static com.example.BTL_App_truyen_tranh.pojo.TruyenTranh get_truyentranh(int idtt, SQLite sqLiteDAO) {
        com.example.BTL_App_truyen_tranh.pojo.TruyenTranh truyenTranh = new com.example.BTL_App_truyen_tranh.pojo.TruyenTranh();
        SQLiteDatabase MyDB = sqLiteDAO.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from truyentranh where idtt = ?", new String[]{String.valueOf(idtt)});
        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
            truyenTranh.setIdTruyen(cursor.getInt(0));
            truyenTranh.setTenTruyen(cursor.getString(1));
            truyenTranh.setNgayDang(cursor.getString(2));
            truyenTranh.setTinhTrang(cursor.getString(3));
            truyenTranh.setTheLoai(cursor.getString(4));
            truyenTranh.setGioiThieu(cursor.getString(5));
            truyenTranh.setImg(cursor.getBlob(6));
            cursor.close();
            return truyenTranh;
        }
        return null;
    }
}
