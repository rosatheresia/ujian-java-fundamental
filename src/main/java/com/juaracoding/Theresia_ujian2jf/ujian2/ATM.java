package com.juaracoding.Theresia_ujian2jf.ujian2;

public class ATM {
        private double saldo;

        // Konstruktor objek ATM
        public ATM(double saldoAwal) {
            this.saldo = saldoAwal;
        }

        // Metode untuk melihat saldo
        public double lihatSaldo() {
            return saldo;
        }

        // Metode untuk setor uang
        public void setorUang(double jumlah) {
            if (jumlah > 0) {
                saldo += jumlah;
            } else {
                throw new IllegalArgumentException("Jumlah harus lebih besar dari 0");
            }
        }

        // Metode untuk tarik uang
        public void tarikUang(double jumlah) {
            if (jumlah > 0 && jumlah <= saldo) {
                saldo -= jumlah;
            } else if (jumlah > saldo) {
                throw new IllegalArgumentException("Saldo tidak mencukupi");
            } else {
                throw new IllegalArgumentException("Jumlah harus lebih besar dari 0");
            }
        }
    }
