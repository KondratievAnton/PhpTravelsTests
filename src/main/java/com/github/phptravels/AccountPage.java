package com.github.phptravels;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountPage {
    private WebDriver driver;
    @FindBy(xpath = "")
    private WebElement usernameOnHeader;

    public AccountPage(WebDriver driver){
        this.driver = driver;
    }
    public String getCurrentUrl() {
        return this.driver.getCurrentUrl();
    }
    public String readUserName() {
        return usernameOnHeader.getText();
    }
}
