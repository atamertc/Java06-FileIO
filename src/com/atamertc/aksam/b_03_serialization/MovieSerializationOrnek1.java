package com.atamertc.aksam.b_03_serialization;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MovieSerializationOrnek1 {

    public static void main(String[] args) {

        Movie movie1 = new Movie("Ruhlarin Kacisi", "Anime",
                LocalDate.of(2001, 10, 15));
        Movie movie2 = new Movie("Seven", "Drama",
                LocalDate.of(2011, 10, 15));

        List<Movie> movieList = new ArrayList<>(List.of(movie1,movie2));

        serilestir(movieList);
        deSerilestir();

    }

    public static void serilestir(List<Movie> movieList) {
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            fos = new FileOutputStream("D:\\BilgeAdamBoost\\JavaFiles\\aksamOrnek4.bin");
            oos = new ObjectOutputStream(fos);
            for (int i = 0; i < movieList.size(); i++) {
                oos.writeObject(movieList.get(i));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                oos.close();
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void deSerilestir() {
        List<Movie> movieList = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("D:\\BilgeAdamBoost\\JavaFiles\\aksamOrnek4.bin"))) {
            Movie movie1;
            while ((movie1 = (Movie) ois.readObject()) != null) {
                movieList.add(movie1);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (EOFException e) {
            System.out.println("Dosyanin sonundayiz");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        for (Movie veri : movieList) {
            System.out.println(veri);
        }

    }
}
