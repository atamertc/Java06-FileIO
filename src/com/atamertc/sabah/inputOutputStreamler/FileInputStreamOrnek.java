package com.atamertc.sabah.inputOutputStreamler;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileInputStreamOrnek {

    public static String dosyaOku(String dosyaYolu,int baslangic,int okunacakKarSay) {
        FileInputStream fis = null;
        String metin = "";
        int karakter;
        try {
            fis = new FileInputStream(dosyaYolu);
            fis.skip(baslangic);
            int sayac = 0;
            while ((karakter = fis.read()) != -1) {
                metin += (char) karakter;
                sayac++;
                if (sayac == okunacakKarSay) {
                    break;
                }
            }
            System.out.println(metin);
        } catch (FileNotFoundException e) {
            System.out.println("Okunacak dosya bulunamadi");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Dosya okuma hatasi");
            e.printStackTrace();
        } finally {
            try {
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return metin;
    }

    public static void main(String[] args) {
        dosyaOku("D:/BilgeAdamBoost/JavaFiles/belgecik.txt",4,6);
    }
}
