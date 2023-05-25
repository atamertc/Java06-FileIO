package com.atamertc.sabah.bufferedFileIO;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BufferedReaderOrnek2 {
    public static void main(String[] args) {
        List<Ogrenci2> ogrenci2List = new ArrayList<>();
        //decorator pattern -> ic ice gecen nesneler:
        try (Scanner sc = new Scanner(new BufferedReader(new FileReader(
                "D:\\BilgeAdamBoost\\JavaFiles\\ogrenciListesi2.txt")))) {
            while (sc.hasNextLine()) {
                String okunanSatir = sc.nextLine();
                //csv dosyalari: Excelden ,
                String[] dizi = okunanSatir.split(",");
                Ogrenci2 ogrenci2 = new Ogrenci2(dizi[0], Integer.parseInt(dizi[1]));
                ogrenci2List.add(ogrenci2);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        for (Ogrenci2 ogr : ogrenci2List) {
            System.out.println(ogr);
        }
    }
}
