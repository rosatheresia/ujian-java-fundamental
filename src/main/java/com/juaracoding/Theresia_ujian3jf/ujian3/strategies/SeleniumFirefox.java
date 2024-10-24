package com.juaracoding.Theresia_ujian3jf.ujian3.strategies;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SeleniumFirefox implements SeleniumStrategy {

    // Menghubungkan ke Firefox
    @Override
    public WebDriver setStrategy() {
        System.setProperty("webdriver.gecko.driver","C:\\Juara Coding\\geckodriver.exe");
        return new FirefoxDriver();
    }
}
