package com.atamertc.sabah.objectSerializiton;

import java.io.Serializable;

public class Otomobil implements Serializable {
    String marka;
    String model;
    int yil;

    public Otomobil(String marka, String model, int yil) {
        this.marka = marka;
        this.model = model;
        this.yil = yil;
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

    @Override
    public String toString() {
        return "Otomobil " +
                "marka='" + marka + '\'' +
                ", model='" + model + '\'' +
                ", yil=" + yil;
    }
}
