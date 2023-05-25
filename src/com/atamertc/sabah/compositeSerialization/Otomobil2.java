package com.atamertc.sabah.compositeSerialization;

import java.io.Serializable;

public class Otomobil2 implements Serializable {
    String marka;
    String model;
    int yil;
    String renk;
    Motor2 motor2;

    public Otomobil2(String marka, String model, int yil, String renk, Motor2 motor2) {
        this.marka = marka;
        this.model = model;
        this.yil = yil;
        this.renk = renk;
        this.motor2 = motor2;
    }

    public String getMarka() {
        return marka;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYil() {
        return yil;
    }

    public void setYil(int yil) {
        this.yil = yil;
    }

    public String getRenk() {
        return renk;
    }

    public void setRenk(String renk) {
        this.renk = renk;
    }

    public Motor2 getMotor2() {
        return motor2;
    }

    public void setMotor2(Motor2 motor2) {
        this.motor2 = motor2;
    }

    @Override
    public String toString() {
        return "Otomobil2 " +
                "marka='" + marka + '\'' +
                ", model='" + model + '\'' +
                ", yil=" + yil +
                ", renk='" + renk + '\'' +
                ", motor2=" + motor2;
    }
}
