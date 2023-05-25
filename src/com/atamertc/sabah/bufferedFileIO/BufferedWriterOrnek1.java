package com.atamertc.sabah.bufferedFileIO;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedWriterOrnek1 {
    public static void main(String[] args) {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(
                "D:\\BilgeAdamBoost\\JavaFiles\\ogrenciListesi2.txt", true))) {
            writer.write("Gulsu Findik,101\n");
            writer.write("Ata Mert Okay,102\n");
            writer.write("Levent Tarik Koyuncu,103\n");
            writer.write("Atamert Cakir,104\n");

        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Yazma islemi tamam");

    }
}
