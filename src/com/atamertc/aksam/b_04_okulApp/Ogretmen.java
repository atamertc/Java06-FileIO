package com.atamertc.aksam.b_04_okulApp;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Ogretmen extends Thread{
    private List<Ogrenci> ogrenciler;
    private String isim;
    BufferedReader bufferedReader;
    public Ogretmen(String isim,BufferedReader bufferedReader) {
        this.isim = isim;
        this.bufferedReader = bufferedReader;
    }

    public void ogrencileriKaydet() {
        FileManager.ogretmenDosyasiOlustur(ogrenciler,isim);
    }

    public void ogrenciNotlariOku() {
        ogrenciler = FileManager.dosyadanVeriOku(bufferedReader, isim);
    }

    public void dosyadanOku() {
        ogrenciler = FileManager.ogrencileriGetir(isim);

    }
    
    public void notEkleVeKaydet(double not) {
        double toplam = 0;
        for (Ogrenci ogrenci : ogrenciler) {
            toplam = (ogrenci.getOrtalama() * 3);
            toplam += not;
            ogrenci.setOrtalama(toplam / 4);
            ogrenci.durumBelirle(toplam / 4);
        }
        ogrencileriKaydet();
    }

    public List<Ogrenci> getOgrenciler() {
        return ogrenciler;
    }

    public void setOgrenciler(List<Ogrenci> ogrenciler) {
        this.ogrenciler = ogrenciler;
    }

    public String getIsim() {
        return isim;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }

    @Override
    public String toString() {
        return "Ogretmen{" +
                "ogrenciler=" + ogrenciler +
                ", isim='" + isim + '\'' +
                '}';
    }

    @Override
    public void run() {
        ogrenciNotlariOku();
    }
}
