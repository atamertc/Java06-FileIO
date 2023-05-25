package com.atamertc.sabah.fileWriterReaderlar;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileWriterOrnek {
    //FIS & FOS: Butun dosya turleri uzerinde IO islemleri yapabiliyordu.
    //Sadece metin dosyalari uzerinde calismak isterseniz FileWriter ve FileReader kullanilir

    public static void main(String[] args) {
        FileWriter fw = null;
        try {
            fw = new FileWriter("D:\\BilgeAdamBoost\\JavaFiles\\filewriteornek.txt");
            fw.write("Metin yaziyok kekeeee");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //try-with-resources: kaynaklarla calisan try
        //bunun kullanilabilmesi icin
        //icindeki sinifin Closeable interface' ini implement etmesi gerekir
        //Bu sayede try icinde acilan yapilar otomatik olarak kapatilir
        //Artik finally blogu ile close metoduna ihtiyac kalmaz
        Scanner sc;
        try (FileWriter fw2 = new FileWriter(
                "D:\\BilgeAdamBoost\\JavaFiles\\filewrite2.txt")) {
            //Metni kullanici girsin
            sc = new Scanner(System.in);
            String girdi = "";
            String metin = "";
            while (!girdi.equals("-1")) {
                if (!girdi.equals("")) {
                    metin += girdi + "\n";
                }
                girdi = sc.nextLine();
            }
            fw2.write(metin);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
