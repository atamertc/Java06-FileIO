package com.atamert.sabah;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class DosyaIndirmeThread {

    public static void main(String[] args) {
        String dosyaYolu = "https://www.yok.gov.tr/Documents/Yayinlar/Yayinlarimiz/Turkiyenin-yuksekogretim-stratejisi.pdf";
        FileDownloadThread downloadThread = new FileDownloadThread(dosyaYolu,"D:\\BilgeAdamBoost\\JavaFiles\\indirilen.pdf");
        downloadThread.start();
        long toplamBoyut = boyutBul(dosyaYolu);
        System.out.println("boyutBul sonucu: " + boyutBul(dosyaYolu));
        while (downloadThread.isAlive()) {
            try {
                Thread.sleep(100);
                System.out.println((downloadThread.inenDosyaBoyutu * 100 / toplamBoyut) + "%");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Indirme tamamlandi");
    }

    public static long boyutBul(String dosyaYolu) {
        try {
            URL url = new URL(dosyaYolu);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("HEAD");
            long dosyaBoyutu = connection.getContentLength();
            return dosyaBoyutu;
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return -1;
        } catch (IOException e) {
            e.printStackTrace();
            return -1;
        }
    }
}

class FileDownloadThread extends Thread {
    int inenDosyaBoyutu = 0;
    String indirilenDosyaYolu;
    String kaydedilecekDosyaYolu;

    public FileDownloadThread(String indirilenDosyaYolu, String kaydedilecekDosyaYolu) {
        this.indirilenDosyaYolu = indirilenDosyaYolu;
        this.kaydedilecekDosyaYolu = kaydedilecekDosyaYolu;
    }

    @Override
    public void run() {
        try (BufferedInputStream inputStream = new BufferedInputStream(new URL(indirilenDosyaYolu).openStream())) {
            FileOutputStream fos = new FileOutputStream(kaydedilecekDosyaYolu);
            //dosya boyutu?
            int toplamDosyaBoyutu = inputStream.available();
            byte[] buffer = new byte[1024]; // 1024 byte = 1 KB
            int okunanBytelar;

            while ((okunanBytelar = inputStream.read(buffer, 0, 1024)) != -1) {
                fos.write(buffer, 0, okunanBytelar);
                inenDosyaBoyutu += okunanBytelar;
            }
            System.out.println("toplamDosyaBoyutu: " + toplamDosyaBoyutu);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
