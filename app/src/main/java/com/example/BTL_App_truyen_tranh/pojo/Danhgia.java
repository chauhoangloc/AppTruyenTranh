package com.example.BTL_App_truyen_tranh.pojo;

import java.util.Date;

public class Danhgia {
    private int iddanhgia;
    private int idtaikhoan;
    private int idtruyentranh;
    private int diem;
    private String noidung;
    private Date ngay;

    public Danhgia(int iddanhgia, int idtaikhoan, int idtruyentranh,int diem,String noidung,Date ngay) {
        this.iddanhgia = iddanhgia;
        this.idtaikhoan = idtaikhoan;
        this.idtruyentranh = idtruyentranh;
        this.diem = diem;
        this.noidung = noidung;
        this.ngay = ngay;
    }
    public int getIddanhgia() {
        return iddanhgia;
    }

    public void setIddanhgia(int iddanhgia) {
        this.iddanhgia = iddanhgia;
    }

    public int getIdtaikhoan() {
        return idtaikhoan;
    }

    public void setIdtaikhoan(int idtaikhoan) {
        this.idtaikhoan = idtaikhoan;
    }

    public int getIdtruyentranh() {
        return idtruyentranh;
    }

    public void setIdtruyentranh(int idtruyentranh) {
        this.idtruyentranh = idtruyentranh;
    }

    public int getDiem() {
        return diem;
    }

    public void setDiem(int diem) {
        this.diem = diem;
    }

    public String getNoidung() {
        return noidung;
    }

    public void setNoidung(String noidung) {
        this.noidung = noidung;
    }

    public Date getNgay() {
        return ngay;
    }

    public void setNgay(Date ngay) {
        this.ngay = ngay;
    }
}
