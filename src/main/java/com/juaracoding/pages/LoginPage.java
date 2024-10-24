package com.juaracoding.pages;

import com.juaracoding.Theresia_ujian3jf.ujian3.SeleniumSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    private WebDriver selenium;

    // Konstuktor Page atau Halaman
    public LoginPage() {
        this.selenium = SeleniumSingleton.getSelenium();
        PageFactory.initElements(selenium, this);
    }

    @FindBy(xpath = "//*[@id=\"user-name\"]")
    private WebElement username;

    @FindBy(xpath = "//*[@id=\"password\"]")
    private WebElement password;

    @FindBy(xpath = "//*[@id=\"login-button\"]")
    private WebElement btnlogin;

    @FindBy(xpath = "/html/body/div/div/div/div[1]/div[1]/div[2]/div")
    private WebElement txtDashboard; // Validasi login berhasil

    @FindBy(xpath = "/html/body/div/div/div[2]/div[1]/div/div/form/div[3]/h3")
    private WebElement txtInvalid; // Validasi loin gagal

    @FindBy(xpath = "//*[@id=\"add-to-cart-sauce-labs-backpack\"]")
    private WebElement btnaddToCart;

    @FindBy(xpath = "/html/body/div/div/div/div[1]/div[1]/div[3]/a")
    private WebElement btnCart;

    @FindBy(xpath = "//*[@id=\"remove-sauce-labs-backpack\"]")
    private WebElement btnRemoveFromCart;

    // Test Login
    public void loginUser(String username, String password) {
        this.username.sendKeys(username);
        this.password.sendKeys(password);
        btnlogin.click();
    }

    // Keterangan Positif Test
    public String getTxtDashboard(){
        return txtDashboard.getText();
    }

    // Keterangan Negatif Test
    public String getTxtInvalid(){
        return txtInvalid.getText();
    }

    // Test Positive Cart
    public void addCartValid(){
        btnaddToCart.click();
        btnCart.click();
    }

    public String getTxtRemove(){
        return btnRemoveFromCart.getText();
    }

}
