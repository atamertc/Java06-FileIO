package com.atamertc.aksam.b_02_fileIslemler;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/*
File Sabitler sinifi olusturalim bu sinifta filemizin degerlerini tutalim
 */
public class FileIslemler extends FileSabitler{
    static Scanner sc = new Scanner(System.in);
    public void menu() {
        System.out.println("1-Dosya yarat");
        System.out.println("2-Dosya sil");
        System.out.println("3-Dosyaya veri ekle");
        System.out.println("4-Dosyadan veri oku");
        System.out.println("5-Dosyadaki bir harfi degistir");
        System.out.println("0-Cikis");
    }

    public void dosyaYarat() {
        if (!FILE.exists()) {
            try {
                FILE.createNewFile();
                System.out.println(FILE.getName()+" isimli dosya basariyla olusturulmustur.");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println(FILE.getPath()+" isimli dosya daha once olusturulmustur.");
        }
    }

    public void dosyaSil() {
        if (FILE.exists()) {
            FILE.delete();
            System.out.println("Dosya basari ile silinmistir");
        } else {
            System.out.println("Silinecek dosya bulunamadi");
        }
    }

    public void veriEkle() {
        System.out.println("Eklemek istediginiz veriyi yaziniz");
        String veri = sc.nextLine();
        System.out.println("Ekleme yaptiginiz veriler devamina mi yazilsin (E/H)");
        boolean kontrol = false;
        String deger = sc.nextLine();
        if (deger.equalsIgnoreCase("E")) {
            kontrol = true;
        }
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(PATH, kontrol))) {
            bufferedWriter.write(veri + "\n");
            System.out.println("Veri ekleme basarili");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<String> veriOku() {
        List<String> veriler = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(PATH))) {
            String veri;
            while ((veri = bufferedReader.readLine()) != null) {
                veriler.add(veri);
            }
            System.out.println("Veriler basariyla okundu: ");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (String veri : veriler) {
            System.out.println(veri);
        }
        return veriler;
    }

    public void harfDegistir() {
        System.out.println("Degistirmek istediginiz harfi giriniz");
        String eski = sc.nextLine();
        System.out.println("Yerine koymak istediginiz harfi giriniz");
        String yeni = sc.nextLine();
        List<String> yeniListe = veriOku().stream()
                .map(x -> x.replace(eski, yeni))
                .toList();
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(PATH))) {
            for (String veri : yeniListe) {
                bufferedWriter.write(veri+"\n");
            }
            System.out.println("Harfler basariyla degistirildi");
            System.out.println("Yeni hali: ");
            for (String veri : yeniListe) {
                System.out.println(veri);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void uygulama() {
        int secim = 0;
        do {
            menu();
            secim = Integer.parseInt(sc.nextLine());
            switch (secim) {
                case 1:
                    dosyaYarat();
                    break;
                case 2:
                    dosyaSil();
                    break;
                case 3:
                    veriEkle();
                    break;
                case 4:
                    veriOku();
                    break;
                case 5:
                    harfDegistir();
                    break;
                case 0:
                    System.out.println("Cikis yapildi");
                    break;
            }
        } while (secim != 0);

    }
}
