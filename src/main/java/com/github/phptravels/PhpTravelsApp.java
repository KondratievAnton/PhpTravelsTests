package com.github.phptravels;

import com.github.tools.Browser;
import org.openqa.selenium.WebDriver;

public class PhpTravelsApp {

    private WebDriver driver;

    public MainPage openMainPage() {
        driver = Browser.open();
        driver.get("https://www.phptravels.net");
        return new MainPage(driver);
    }

    public LoginPage openLoginPage() {
        driver =  Browser.open();
        driver.get("https://www.phptravels.net/login");
        return new LoginPage(driver);
    }
    public void close() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
