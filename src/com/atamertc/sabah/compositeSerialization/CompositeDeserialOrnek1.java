package com.atamertc.sabah.compositeSerialization;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class CompositeDeserialOrnek1 {
    public static void main(String[] args) {

        try (ObjectInputStream input = new ObjectInputStream(new FileInputStream(
                "D:\\BilgeAdamBoost\\JavaFiles\\otomobil2.bin"))) {
            ArrayList<Otomobil2> liste = (ArrayList<Otomobil2>) input.readObject();
            for (Otomobil2 oto : liste) {
                System.out.println(oto);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}
