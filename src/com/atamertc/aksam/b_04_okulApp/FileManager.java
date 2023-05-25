package com.atamertc.aksam.b_04_okulApp;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FileManager {

    static File file = new File("D:\\BilgeAdamBoost\\JavaFiles\\okulAppOgrenci.txt");

    public static List<Ogrenci> dosyadanVeriOku(BufferedReader bufferedReader, String ogretmenIsmi) {
        List<Ogrenci> ogrenciler = new ArrayList<>();
        String o1 = "";

        try {
            while ((o1 = bufferedReader.readLine()) != null) {
                String[] array = o1.split(",");
                String isim = array[0];
                List<String> list = Arrays.asList(array).subList(1, 4);
                Double ort = ortHeseapla(list);
                LocalDate date = Utility.stringToLocalDateDayMonthYear(array[array.length - 1]);
                Ogrenci ogrenci = new Ogrenci(isim, ort, date);
                ogrenciler.add(ogrenci);
                System.out.println(ogretmenIsmi + " adli ogretmen ===> " + ogrenci.getIsim() +
                        " adli ogrencinin notunu okudu");
                Thread.sleep(1000);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        return ogrenciler;
    }

    private static Double ortHeseapla(List<String> list) {

        // list.stream().map(x ->
        // Double.parseDouble(x)).collect(Collectors.averagingDouble(y -> y));

        return list.stream().collect(Collectors.averagingDouble(x -> Double.parseDouble(x)));
    }

    public static void ogretmenDosyasiOlustur(List<Ogrenci> ogrenciler, String isim) {
        try (ObjectOutputStream writer = new ObjectOutputStream(
                new FileOutputStream("D:\\BilgeAdamBoost\\JavaFiles\\" + isim + ".txt"))) {
            writer.writeObject(ogrenciler);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Ogrenci> ogrencileriGetir(String isim) {
        List<Ogrenci> ogrenciler = new ArrayList<>();
        try (ObjectInputStream inputStream = new ObjectInputStream(
                new FileInputStream("D:\\BilgeAdamBoost\\JavaFiles\\" + isim + ".txt"))) {
            ogrenciler = (List<Ogrenci>) inputStream.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return ogrenciler;
    }
}
