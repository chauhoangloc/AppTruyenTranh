package com.example.BTL_App_truyen_tranh.DTO;

public class LichSu {
    private int idlichsu;
    private int idtaikhoan;
    private int idTruyenTranh;
    private int idchap;

    public LichSu(int idlichsu, int idtaikhoan, int  idTruyenTranh,int idchap ) {
        this.idlichsu = idlichsu;
        this.idtaikhoan = idtaikhoan;
        this.idTruyenTranh = idTruyenTranh;
        this.idchap=idchap;
    }
    public int getIdlichsu() {
        return idlichsu;
    }

    public void setIdlichsu(int idlichsu) {
        this.idlichsu = idlichsu;
    }

    public int getIdtaikhoan() {
        return idtaikhoan;
    }

    public void setIdtaikhoan(int idtaikhoan) {
        this.idtaikhoan = idtaikhoan;
    }

    public int getIdTruyenTranh() {
        return idTruyenTranh;
    }

    public void setIdTruyenTranh(int idTruyenTranh) {
        this.idTruyenTranh = idTruyenTranh;
    }

    public int getIdchap() {
        return idchap;
    }

    public void setIdchap(int idchap) {
        this.idchap = idchap;
    }
}
