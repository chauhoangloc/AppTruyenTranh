package com.example.BTL_App_truyen_tranh.SQL;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.Date;

public class SQLite extends SQLiteOpenHelper {
    public SQLite(@Nullable Context context) {
        super(context, "DATASQLITE", null, 1);
    }

    public void get_data(String sql) {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        sqLiteDatabase.execSQL(sql);
    }

    public Cursor doc_data(String sql) {
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        return sqLiteDatabase.rawQuery(sql, null);
    }

    public void getdatatk() {
        get_data("create Table IF NOT EXISTS taikhoan(idtk INTEGER PRIMARY KEY AUTOINCREMENT,tk nvarchar(50), hoten nvarchar(50),mk nvarchar(50),role INTEGER)");
       /* get_data("INSERT INTO taikhoan (tk, hoten, mk, role) VALUES ('admin', 'admin', 'admin', 1)");*/
        /*(get_data("INSERT INTO taikhoan (tk, hoten, mk, role) VALUES ('test1', 'test1', 'test1', 2)");*/
    }
    public void getdatatkieuTruyen() {
        get_data("CREATE TABLE IF NOT EXISTS KieuTruyen(idkt INTEGER PRIMARY KEY AUTOINCREMENT,namekt TEXT)");
    }
    public void getdatatLichSu() {
        get_data("CREATE TABLE IF NOT EXISTS LichSU(idlichsu INTEGER PRIMARY KEY AUTOINCREMENT,idtaikhoan INTEGER,idTruyenTranh INTEGER,idchap INTEGER)");
    }
    public void getdatatDanhgia() {
        get_data("CREATE TABLE IF NOT EXISTS Danhgia(iddanhgia INTEGER PRIMARY KEY AUTOINCREMENT,idtaikhoan INTEGER,idtruyentranh INTEGER,diem INTEGER,noidung TEXT,ngay TEXT)");
    }
    public void getdatatl() {
        get_data("CREATE TABLE IF NOT EXISTS theloai(idtl INTEGER PRIMARY KEY AUTOINCREMENT,tentl text)");
       /* get_data("INSERT INTO theloai (tentl) VALUES ('ngôn tình')");
        get_data("INSERT INTO theloai (tentl) VALUES ('Chuyển Sinh')");
        get_data("INSERT INTO theloai (tentl) VALUES ('Hài Hước')");*/
    }

    public void getdataTruyenTranh() {
        get_data("create Table IF NOT EXISTS truyentranh(idtt INTEGER PRIMARY KEY AUTOINCREMENT,tenTruyen text,ngayDang text , tinhTrang text,int hot, theLoai text ,gioiThieu text, img blob)");
    }


    public void getdataChap() {
        get_data("create Table IF NOT EXISTS chap(idChap INTEGER PRIMARY KEY AUTOINCREMENT,idtt INTEGER,tenChap text)");

    }
    public void getdataImgChap() {
        get_data("create Table IF NOT EXISTS imgchap(idimgChap INTEGER PRIMARY KEY AUTOINCREMENT,idtt INTEGER,tenChap text,img blob)");
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

}