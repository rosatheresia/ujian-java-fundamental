package com.juaracoding.Theresia_ujian1jf.ujian1;

import java.util.Date;
import java.util.Scanner;

public class Soal3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Jumlah Tiket = ");

        // Declarition Variable Tiket
        double jumlah_Tiket = scanner.nextDouble();

        System.out.print("Day = ");
        double day = scanner.nextDouble();

        double discount, totalHargaDay, totalHargaEnd, totalHargaDayNon, totalHargaEndNon;

        // Value Variable Tiket
        discount = 0.01;
        totalHargaDay = jumlah_Tiket * 35000 - (jumlah_Tiket * discount * 35000);
        totalHargaEnd = jumlah_Tiket * 45000 - (jumlah_Tiket * discount * 45000);
        totalHargaDayNon = jumlah_Tiket * 35000;
        totalHargaEndNon = jumlah_Tiket * 45000;


        // Percabangan
        if (jumlah_Tiket > 5)
            if (day <= 5) {
                System.out.println("Total harga (dengan diskon) : " + totalHargaDay);
            } else {
                System.out.println("Total harga (dengan diskon) : " + totalHargaEnd);
            }
        else {
            if (day > 5) {
                System.out.println("Total harga (tanpa diskon) : " + totalHargaEndNon);
            } else {
                System.out.println("Total harga (tanpa diskon) : " + totalHargaDayNon);
            }

        }
    }
}
