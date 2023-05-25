package com.atamertc.sabah.fileWriterReaderlar;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileReaderOgrenci {

    public static void main(String[] args) {

        List<Ogrenci> ogrenciList = new ArrayList<>();

        try (Scanner sc = new Scanner(new FileReader(
                "D:\\BilgeAdamBoost\\JavaFiles\\ogrenciListesi.txt"))) {
            while (sc.hasNextLine()) {
                String s = sc.nextLine();
                System.out.println(s);
                String[] arr = s.split(",");
                Ogrenci ogr1 = new Ogrenci(arr[0], Integer.parseInt(arr[1]));
                ogrenciList.add(ogr1);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(ogrenciList);
    }
}
