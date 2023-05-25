package com.atamertc.aksam.b_01_inputOutputStream;

import java.io.*;

public class OkumaYazmaOrnek1 {
    public static void main(String[] args) {

        //output --> dosyaya yazma
        //input --> dosyayi okuma

        File file = new File("D:\\BilgeAdamBoost\\JavaFiles\\aksamOrnek2.txt");
        FileOutputStream fos = null;
        FileInputStream fis = null;
        try {
            //1. yol
            fos = new FileOutputStream(
                    "D:\\BilgeAdamBoost\\JavaFiles\\aksamOrnek1.txt",false);
            //2. yol
            FileOutputStream fos2 = new FileOutputStream(file);
            String kelime = "Hello World";
            fos.write(kelime.getBytes());

            //okuma islemleri
            fis = new FileInputStream(
                    "D:\\BilgeAdamBoost\\JavaFiles\\aksamOrnek1.txt");
            int deger;
            while ((deger = fis.read()) != -1) {
                System.out.print((char) deger);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fos != null) {
                    fos.close();
                }
                if (fis != null) {
                    fis.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
