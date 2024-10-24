package com.juaracoding;

import com.juaracoding.Theresia_ujian3jf.ujian3.SeleniumSingleton;
import com.juaracoding.pages.LoginPage;
import com.juaracoding.utils.Utils;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginTest {
    private WebDriver selenium;

    private LoginPage loginPage;

    // Mengelola Webdriver
    @BeforeClass
    public void setUp() {
        SeleniumSingleton.getInstance("firefox");
        selenium = SeleniumSingleton.getSelenium();
        selenium.get("https://www.saucedemo.com/");
        loginPage = new LoginPage();
    }

    @AfterClass
    public void finish(){
        Utils.delay(5); // Memberi jeda selama 5 detik
        SeleniumSingleton.closeObjectInstance();
    }

    // Positif Test Valid Login
    @Test
    public void testValidLogin(){
        selenium.get("https://www.saucedemo.com/"); // Memanggil ulang website agar dapat riset Username dan Password
        loginPage.loginUser("standard_user", "secret_sauce");
        Assert.assertEquals(loginPage.getTxtDashboard(), "Swag Labs");
    }

    // Negative Test Invalid Login
    @Test
    public void testInvalidLogin(){
        Utils.delay(3);
        loginPage.loginUser("theresia","secret_sauce");
        Assert.assertEquals(loginPage.getTxtInvalid(), "Epic sadface: Username and password do not match any user in this service");

        selenium.get("https://www.saucedemo.com/"); // Memanggil ulang website agar dapat riset Username dan Password
        loginPage.loginUser("standard_user", "");
        Assert.assertEquals(loginPage.getTxtInvalid(),"Epic sadface: Password is required");
        Utils.delay(5);
    }

    // Test Positive Add Product to Cart
    @Test(priority = 3)
    public void addProductToCartValid() {
        Utils.delay(5);
        loginPage.addCartValid();
        Assert.assertEquals(loginPage.getTxtRemove(), "Remove");
    }

}
