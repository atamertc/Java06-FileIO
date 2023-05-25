package com.atamertc.sabah.inputOutputStreamler;

import java.io.*;
import java.util.Scanner;

//IO: Input Output -> Byte byte gerceklestirilir. 8 bit = 1 byte = 1 char
//Source -> Stream -> Destination
public class FileIOOrnek1 {

    public static void main(String[] args) {

        //System.out.println("Java"); // Programdan consola veri aktarmak icin
        //Scanner sc = new Scanner(System.in); // Consoldan programa veri aktarmak icin
        //Bu islemlerde byte byte aktarim soz konusudur.

        //OutputStream: Yazma islemleri icin kullanilan abstract sinif
        //icindeki 3 metod:
        //write(): byte dizisini yazmak icin kullanilir
        //flush(): tamponlanmis veriyi hizli bir sekilde yazmak icin kullanilir
        //tamponlamak bir veriyi yazarken byte lari biriktirip toplu yazmak tek tek gitmemek
        //close(): OutputStream'i kapatmaya yarar

        //InputStream: Okuma islemleri icin kullanilan abstract sinif
        //InputStream 2 metod:
        //read(): veriyi okumak icin kullanilacak
        //dosyada okunacak karakter bulamadiginda -1 doner
        //close(): InputStream'i kapatmaya yarar

        //Dosya yazmak icin: FileOutputStream sinifini kullanicaz
        //Dosyadan okumak icin: FileInputStream sinifini kullanicaz

        //Source -> FileInputStream -> Java Programimiz
        //Java Programimiz -> FileOutpuStream -> Dosya

        //1. Yol
        //File file = new File("Belge.txt"); -> relative path
        //2. Yol
        FileOutputStream fos = null;
        try {
            //absolute path -v
            fos = new FileOutputStream(
                    "D:/BilgeAdamBoost/JavaFiles/belgecik.txt",true);
            //write(byte[] b) kullanimi
            //byte[] bytes = {' ','J', 'A', 'V', 'A'};
            //fos.write(bytes);

            String sehir = "\nCakir";
            fos.write(sehir.getBytes());
        } catch (FileNotFoundException e) {
            System.out.println("Fos'a file eklenirken hata geldi");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Yazma isleminde hata geldi");
            e.printStackTrace();
        } finally {
            try {
                fos.close();
            } catch (IOException e) {
                System.out.println("Fos kapatmada hata geldi");
                e.printStackTrace();
            }
        }


    }
}
