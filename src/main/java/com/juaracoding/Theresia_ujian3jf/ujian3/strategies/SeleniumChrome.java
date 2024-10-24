package com.juaracoding.Theresia_ujian3jf.ujian3.strategies;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SeleniumChrome implements SeleniumStrategy {

    // Menghubungkan ke Chrome
    @Override
    public WebDriver setStrategy() {
        System.setProperty("webdriver.chrome.driver","C:\\Juara Coding\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("useAutomationExtension", false);
        options.addArguments("--no-sandbox");
        return new ChromeDriver(options);
    }
}
