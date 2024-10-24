package com.juaracoding.Theresia_ujian3jf.ujian3;

import com.juaracoding.Theresia_ujian3jf.ujian3.strategies.SeleniumStrategy;
import com.juaracoding.Theresia_ujian3jf.ujian3.strategies.SeleniumStrategyImplementer;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class SeleniumSingleton {

    private static SeleniumSingleton instance = null;
    private static WebDriver selenium; // Hasil pemilihan Chrome atau Firefox

    // Passing atau Melewati data dari konstruktor
    public SeleniumSingleton(String selenium) {
        instantiate(selenium);
    }

    // Colokan atau Penghubung dapat berjalan
    public WebDriver instantiate(String strategy) {
        SeleniumStrategy seleniumStrategy = SeleniumStrategyImplementer.chooseStrategy(strategy);
        selenium = seleniumStrategy.setStrategy();
        selenium.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);  // setting 10 detik
        selenium.manage().window().maximize();
        return selenium;
    }

    // Konstruktor
    public static SeleniumSingleton getInstance(String selenium) {
        if (instance == null) {
            instance = new SeleniumSingleton(selenium);
        }
        return instance;
    }

    // Untuk mendapatkan browser (Chrome atau Firefox) yang sudah dipilih
    public static WebDriver getSelenium() {
        return selenium;
    }

    // Close atau Menutup browser (Chrome atau Firefox)
    public static void closeObjectInstance(){
        instance = null;
        selenium.quit();
    }
}
