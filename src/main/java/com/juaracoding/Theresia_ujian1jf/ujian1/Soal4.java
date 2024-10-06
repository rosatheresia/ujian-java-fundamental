package com.juaracoding.Theresia_ujian1jf.ujian1;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Soal4 {
 public static void main(String[] args) {
/*

     System.out.println("Daftar film bioskop");
     Scanner sc = new Scanner(System.in);
     String filmArray[] = {"Avenger : Endgame", "Spider-Man : Homecoming",
             "Black Panther","Thor : Ragnarok", "Doctor Strange"};

     int noFilm = sc.nextInt();
     System.out.println("Nomor Urut Film " + noFilm);
     System.out.println("Masukkan nama film " + noFilm + " : " + filmArray[noFilm-1]);
*/


     String filmArray[] = {"Avenger : Endgame", "Spider-Man : Homecoming",
             "Black Panther","Thor : Ragnarok", "Doctor Strange"};

     System.out.println("Daftar film bioskop");
     int y = 0;
     do {
         System.out.println("Masukkan nama film " + y + " : " + filmArray[y]);
         y++;
     }while(filmArray.length >= y);

     System.out.println("Film yang ingin ditonton : ");
     int x = 0;
     do {
         System.out.println(x + ". " + filmArray[x]);
         x++;
     }while(x < filmArray.length);
 }
}
