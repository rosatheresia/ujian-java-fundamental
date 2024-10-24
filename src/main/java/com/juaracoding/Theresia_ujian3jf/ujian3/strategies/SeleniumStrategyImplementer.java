package com.juaracoding.Theresia_ujian3jf.ujian3.strategies;

public class SeleniumStrategyImplementer {

    // Memilih Interface antara Chrome atau Firefox
    public static SeleniumStrategy chooseStrategy(String strategy) {
        switch (strategy) {
            case "chrome":
                return new SeleniumChrome();
            case "firefox":
                return new SeleniumFirefox();
            default:
                return null;
        }
    }
}
