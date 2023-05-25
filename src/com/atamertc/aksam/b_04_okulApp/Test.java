package com.atamertc.aksam.b_04_okulApp;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Test {

    public static void main(String[] args) {
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(FileManager.file));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Ogretmen ogretmen = new Ogretmen("Mustafa", bufferedReader);
        Ogretmen ogretmen2 = new Ogretmen("Baris", bufferedReader);

        ogretmen.start();
        ogretmen2.start();

        try {
            ogretmen.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        ogretmen.ogrencileriKaydet();
        ogretmen2.ogrencileriKaydet();

        System.out.println(ogretmen.getIsim() + " toplam " + ogretmen.getOgrenciler().size() + "adet not okudu.");
        System.out.println(ogretmen2.getIsim() + " toplam " + ogretmen2.getOgrenciler().size() + " adet not okudu.");
        try {
            System.out.println("a");
        } catch (Exception e) {

        }



    }
}
