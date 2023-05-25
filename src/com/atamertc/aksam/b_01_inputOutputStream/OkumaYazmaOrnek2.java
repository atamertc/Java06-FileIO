package com.atamertc.aksam.b_01_inputOutputStream;

import java.io.*;

public class OkumaYazmaOrnek2 {
    public static void main(String[] args) {

        String path = "D:\\BilgeAdamBoost\\JavaFiles\\aksamOrnek2.txt";
        File file1 = new File(path);

        if (!file1.exists()) {
            try {
                file1.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Dosya daha once olusturulmustur");
        }
        FileWriter fileWriter;
        BufferedWriter bufferedWriter = null;
        try {
            fileWriter = new FileWriter(file1,true);
            bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write("Deneme");
            bufferedWriter.flush();
            System.out.println("Yazma islemi basarili");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bufferedWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println("-------------------------------------------------------");
        /////////////////////////////////////////////////////////////
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file1))) {
            String deger;
            while ((deger = bufferedReader.readLine()) != null) {
                System.out.println(deger);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
