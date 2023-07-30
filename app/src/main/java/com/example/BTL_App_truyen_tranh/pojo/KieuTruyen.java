package com.example.BTL_App_truyen_tranh.pojo;

public class KieuTruyen {
    private int idkt;
    private String namekt;


    public KieuTruyen() {
    }
    public KieuTruyen(int idkt, String namekt) {
        this.idkt = idkt;
        this.namekt = namekt;
    }
    public String getNamekt() {
        return namekt;
    }

    public void setNamekt(String namekt) {
        this.namekt = namekt;
    }

    public int getIdkt() {
        return idkt;
    }

    public void setIdkt(int idkt) {
        this.idkt = idkt;
    }
}
