package com.atamertc.sabah.arrayListSerializiton;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class ArrayListSerialOrnek1 {
    public static void main(String[] args) {

        Ogrenci3 ogr1 = new Ogrenci3("Ogr1", 100);
        Ogrenci3 ogr2 = new Ogrenci3("Ogr2", 100);
        Ogrenci3 ogr3 = new Ogrenci3("Ogr3", 100);

        ArrayList<Ogrenci3> ogrenci3ArrayList = new ArrayList<>();
        ogrenci3ArrayList.add(ogr1);
        ogrenci3ArrayList.add(ogr2);
        ogrenci3ArrayList.add(ogr3);

        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(
                "D:\\BilgeAdamBoost\\JavaFiles\\ogrenciler.bin"))) {

            out.writeObject(ogrenci3ArrayList);

        } catch (FileNotFoundException e) {
            System.out.println("Dosya bulunamadi");
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Arraylist dosyalastirildi");
    }
}
