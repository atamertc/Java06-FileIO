package com.atamertc.sabah.bufferedFileIO;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class BufferedReaderOrnek1 {
    public static void main(String[] args) {

        //dosyadanBirSatirOkuma();
        dosyaninHepsiniOkuma();
    }

    private static void dosyaninHepsiniOkuma() {
        try (BufferedReader reader = new BufferedReader(new FileReader(
                "D:\\BilgeAdamBoost\\JavaFiles\\listeTakimlar.txt"))) {
            String okunanSatir;
            int sayac = 0;
            while ((okunanSatir = reader.readLine()) != null) {
                sayac++;
                System.out.println(sayac +"- "+okunanSatir);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void dosyadanBirSatirOkuma() {
        try (BufferedReader reader = new BufferedReader(new FileReader(
                "D:\\BilgeAdamBoost\\JavaFiles\\listeTakimlar.txt"))) {

            String okunanSatir = reader.readLine();//Satir satir okuma -> readLine()
            System.out.println(okunanSatir);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
