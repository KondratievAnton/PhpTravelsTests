package com.github.phptravels;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage {
    private WebDriver driver;
    @FindBy(xpath = "//ul[2]/ul/li/a")
    private WebElement myAccountButton;
    @FindBy(xpath = "//ul[2]/ul/li/ul/li/a")
    private WebElement loginOption;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }
    public LoginPage navigateToLoginPage() {
        clickMyAccountButton();
        clickLoginOption();
        return new LoginPage(driver);
    }
    public void clickMyAccountButton() {
        myAccountButton.click();
    }
    public void clickLoginOption() {
        loginOption.click();
    }
}
