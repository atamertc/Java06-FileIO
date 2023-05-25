package com.atamertc.sabah.objectSerializiton;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class DeserializationOrnek1 {
    public static void main(String[] args) {

        try (ObjectInputStream input = new ObjectInputStream(new FileInputStream(
                "D:\\BilgeAdamBoost\\JavaFiles\\otomobil.bin"))) {
            //Queue yapisi gibi okur ilk yazilani ilk bastirir
            Otomobil oto;
            while ((oto = (Otomobil) input.readObject()) != null) {
                System.out.println(oto);
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
