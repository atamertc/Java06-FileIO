package com.atamertc.sabah.objectSerializiton;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SerializationOrnek1 {
    public static void main(String[] args) {

        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(
                "D:\\BilgeAdamBoost\\JavaFiles\\otomobil.bin"))) {

            Otomobil oto1 = new Otomobil("Opel", "Insignia", 2020);
            Otomobil oto2 = new Otomobil("BMW", "5.18", 2022);
            Otomobil oto3 = new Otomobil("Mercedes", "S450", 2023);
            out.writeObject(oto1);
            out.writeObject(oto2);
            out.writeObject(oto3);
            out.writeObject(null);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
