package com.juaracoding.Theresia_ujian1jf.ujian1;

public class Soal5 {
    public static void main(String[] args) {

        // Declarition Film
        int[][] hargaFilm = {{1,2,3,4,5},{50000,60000,70000,80000,90000}};
        int sum = 0;

        // Mencetak Harga Tiket Film menggunakan Array
        for (int i = 0; i < hargaFilm.length; i++) {
            for (int j = 0; j < hargaFilm[i].length; j++) {
                    System.out.println("Harga tiket film " + hargaFilm[0][j] + " : " + hargaFilm[1][j]);
                    sum += hargaFilm[1][j]; // untuk menghasilkan harga tiket 50000 - 90000
            }
            break; // Memberhentikan perhitungan
        }
        System.out.println("Total harga tiket : " + sum);
    }
}
