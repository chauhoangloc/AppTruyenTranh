package com.example.BTL_App_truyen_tranh.Activity.Login;

import static com.example.BTL_App_truyen_tranh.Utils.XuLySuKien.ANIMATION;
import static com.example.BTL_App_truyen_tranh.Utils.XuLySuKien.ANIMATIONDOWN;
import static com.example.BTL_App_truyen_tranh.Utils.XuLySuKien.ANIMATIONUP;
import static com.example.BTL_App_truyen_tranh.SQL.TaiKhoan.kiem_tra_dn;
import static com.example.BTL_App_truyen_tranh.SQL.TaiKhoan.kiem_tra_role;


import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.airbnb.lottie.LottieAnimationView;
import com.example.BTL_App_truyen_tranh.SQL.SQLite;
import com.example.BTL_App_truyen_tranh.pojo.TaiKhoan;
import com.example.BTL_App_truyen_tranh.Activity.Home.HomePage;
import com.example.BTL_App_truyen_tranh.Activity.QuanLyTruyen.HomeQuanLy;
import com.example.BTL_App_truyen_tranh.R;

public class DangNhapActivity extends AppCompatActivity {
    LottieAnimationView animationViewLogo;
    ImageView imageLogo;
    TextView textAppName, text_dang_ky;
    Button button_dang_nhap;
    EditText edit_taikhoan, edit_mat_khau;
    SQLite sqLite;
    CharSequence charSequence;
    int index;
    long delay = 200;
    Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dang_nhap);
        anhXa();
        //Khởi tạo animation
        Animation animationZoomIn = AnimationUtils.loadAnimation(this, R.anim.zoom_in);
        //Bắt đầu animation
        animationViewLogo.setAnimation(animationZoomIn);
        onClick();
        //Tạo hoạn ảnh cho nút ấn

    }

    private void onClick() {
        text_dang_ky.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                //Kiểm tra xem sự kiện bằng DOWN
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    //Bắt hiệu ứng cho text
                    text_dang_ky.startAnimation(ANIMATIONUP);
                } else {
                    //Kiểm tra xem sự kiện bằng UP
                    if (event.getAction() == MotionEvent.ACTION_UP) {
                        //Bắt hiệu ứng cho text
                        text_dang_ky.startAnimation(ANIMATIONDOWN);

                        startActivity(new Intent(DangNhapActivity.this, DangKyActivity.class));
                    }
                }
                return true;
            }
        });
        button_dang_nhap.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                //Kiểm tra xem sự   kiện bằng DOWN
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    //Bắt hiệu ứng cho text
                    button_dang_nhap.startAnimation(ANIMATIONUP);
                } else {
                    //Kiểm tra xem sự kiện bằng UP
                    if (event.getAction() == MotionEvent.ACTION_UP) {
                        //Bắt hiệu ứng cho text
                        button_dang_nhap.startAnimation(ANIMATIONDOWN);
                        signIn();
                    }
                }
                return true;
            }
        });
    }

    private void signIn() {
        String tk = edit_taikhoan.getText().toString().trim();
        String mk = edit_mat_khau.getText().toString().trim();
        if (tk.isEmpty() || mk.isEmpty()) {
            Toast.makeText(DangNhapActivity.this, "Vui lòng điền đủ thông tin", Toast.LENGTH_SHORT).show();
        } else {
            TaiKhoan taiKhoan = new TaiKhoan(0, tk, "", mk);

                if (!kiem_tra_dn(taiKhoan, sqLite).isEmpty()) {
                    int role = kiem_tra_role(taiKhoan, sqLite);
                    if (role == 1) {
                        Intent intent = new Intent(DangNhapActivity.this, HomeQuanLy.class);
                        startActivity(intent);
                        finish();
                    } else{
                        Toast.makeText(DangNhapActivity.this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(DangNhapActivity.this, HomePage.class);
                        intent.putExtra("Key_hoten",  kiem_tra_dn(taiKhoan, sqLite));
                        startActivity(intent);
                        finish();
                    }
                } else {
                    Toast.makeText(DangNhapActivity.this, "Tài khoản chưa được đăng ký", Toast.LENGTH_SHORT).show();
                }


        }

    }

    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            //Khi được chạy
            //Set Text
            textAppName.setText(charSequence.subSequence(0, index++));
            //Kiểm tra tình trạng
            if (index <= charSequence.length()) {
                handler.postDelayed(runnable, delay);
            }
        }
    };

    private void anhXa() {
        ANIMATION(this);
        animationViewLogo = findViewById(R.id.animationViewLogo);
        textAppName = findViewById(R.id.textAppName);
        edit_taikhoan = findViewById(R.id.edit_taikhoan);
        edit_mat_khau = findViewById(R.id.edit_mat_khau);
        button_dang_nhap = findViewById(R.id.button_dang_nhap);
        text_dang_ky = findViewById(R.id.text_dang_ky);
        sqLite = new SQLite(DangNhapActivity.this);
        sqLite.getdatatk();
        sqLite.getdatatDanhgia();
        sqLite.getdatatkieuTruyen();
        sqLite.getdatatLichSu();
    }

    public void animatText(CharSequence cs) {
        //Set text
        charSequence = cs;
        //Đặt lại index về 0;
        index = 0;
        //Xóa văn bản
        textAppName.setText("");
        //Xóa cuộc gọi lại

        //Chạy handler
        handler.postDelayed(runnable, delay);
    }
}