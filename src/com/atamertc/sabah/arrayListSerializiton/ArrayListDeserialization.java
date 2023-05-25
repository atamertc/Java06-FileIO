package com.atamertc.sabah.arrayListSerializiton;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class ArrayListDeserialization {
    public static void main(String[] args) {

        try (ObjectInputStream input = new ObjectInputStream(new FileInputStream(
                "D:\\BilgeAdamBoost\\JavaFiles\\ogrenciler.bin"))) {

            ArrayList<Ogrenci3> list = (ArrayList<Ogrenci3>) input.readObject();
            for (Ogrenci3 ogr : list) {
                System.out.println(ogr);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("Program devam ediyorke");

    }
}
