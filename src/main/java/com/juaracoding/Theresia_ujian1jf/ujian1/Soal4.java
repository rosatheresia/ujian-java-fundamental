package com.juaracoding.Theresia_ujian1jf.ujian1;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Soal4 {
 public static void main(String[] args) {

     // Declarition Nama film ke dalam Array
     String filmArray[] = new String[6];
     filmArray[1] = "Avenger: Endgame";
     filmArray[2] = "Spider-Man: Homecoming";
     filmArray[3] = "Black Panther";
     filmArray[4] = "Thor: Ragnarok";
     filmArray[5] = "Doctor Strange";

     // Perulangan
     System.out.println("Daftar film bioskop");
     int y = 1; // Mencetak filmArray ke-1
     do {
         System.out.println("Masukkan nama film " + y + " : " + filmArray[y]);
         y++;
     }while(y < filmArray.length);

     System.out.println("Film yang ingin ditonton : ");
     int x = 1; // Mencetak filmArray ke-1
     do {
         System.out.println(x + ". " + filmArray[x]);
         x++;
     }while(x < filmArray.length);
 }
}
