package com.atamertc.sabah.inputOutputStreamler;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DosyaKopyalama {

    //Kopya olusturmak:
    //1. Dosyayi okumam gerekir. Okudugum belgenin degerlerini ArrayList icinde saklamaliyiz.
    //2. ArrayListteki verilerle yeni dosya yazmamiz gerekli

    public static void main(String[] args) {
        kopyaOlustur("D:/BilgeAdamBoost/JavaFiles/belgecikKopya.txt",
                dosyaOku("D:/BilgeAdamBoost/JavaFiles/belgecik.txt"));
    }

    public static void kopyaOlustur(String dosyaYolu, List<Integer> liste) {
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(dosyaYolu);
            for (Integer data :
                    liste) {
                fos.write(data);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Dosya yolu bulunamadi");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Dosya yazma hatasi");
            e.printStackTrace();
        }
    }
    public static List<Integer> dosyaOku(String dosyaYolu) {
        List<Integer> list = new ArrayList<>();
        FileInputStream fis = null;
        int karakter;
        try {
            fis = new FileInputStream(dosyaYolu);
            while ((karakter = fis.read()) != -1) {
                list.add(karakter);
            }

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
        return list;
    }
}
