package com.github.phptravels;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    private WebDriver driver;
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }
    public AccountPage loginAs(String username, String password) {
        enterUserName(username);
        enterPassword(password);
        clickLoginButton();
        return new AccountPage(driver);
    }
    public void enterUserName(String username) {
        WebElement emailField = By.name("username").findElement(driver);
        emailField.sendKeys("user@phptravels.com");
    }
    public void enterPassword(String password) {
        WebElement passwordField = By.name("password").findElement(driver);
        passwordField.sendKeys("demouser");
    }
    public void clickLoginButton() {
        WebElement loginButton = By.cssSelector(".loginbtn").findElement(driver);
        loginButton.click();
    }
}