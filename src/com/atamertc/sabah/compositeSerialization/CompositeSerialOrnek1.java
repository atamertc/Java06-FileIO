package com.atamertc.sabah.compositeSerialization;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class CompositeSerialOrnek1 {
    public static void main(String[] args) {
        Otomobil2 oto1 = new Otomobil2("Oto1", "Oto1Model1", 2022, "Beyaz", new Motor2(1000));
        Otomobil2 oto2 = new Otomobil2("Oto2", "Oto2Model1", 2021, "Siyah", new Motor2(2000));
        Otomobil2 oto3 = new Otomobil2("Oto3", "Oto3Model1", 2023, "Gri", new Motor2(3000));
        Otomobil2 oto4 = new Otomobil2("Oto4", "Oto4Model1", 2020, "Kirmizi", new Motor2(4000));
        ArrayList<Otomobil2> list = new ArrayList<>();
        list.add(oto1);
        list.add(oto2);
        list.add(oto3);
        list.add(oto4);

        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(
                "D:\\BilgeAdamBoost\\JavaFiles\\otomobil2.bin"))) {

            out.writeObject(list);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
