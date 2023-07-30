package com.example.BTL_App_truyen_tranh;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.BTL_App_truyen_tranh.SQL.SQLite;

public class MainActivity extends AppCompatActivity {
    public static SQLite sqLite;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sqLite = new SQLite(this);
        sqLite.getdatatDanhgia();
        sqLite.getdatatkieuTruyen();

    }
}
