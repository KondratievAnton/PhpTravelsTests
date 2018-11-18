package com.github.authorization;

import com.github.phptravels.AccountPage;
import com.github.phptravels.LoginPage;
import com.github.phptravels.MainPage;
import com.github.phptravels.PhpTravelsApp;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class LoginFromAccountDropdownTest {
    private PhpTravelsApp phpTravelsApp = new PhpTravelsApp();
    private MainPage mainPage;
    private LoginPage loginPage;
    public AccountPage accountPage;

    @Test
    public void loginFromAccountDropdownTest() {
        mainPage = phpTravelsApp.openMainPage();
        waitFor(3);
        loginPage = mainPage.navigateToLoginPage();
        waitFor(3);
        loginPage.loginAs("user@phptravels.com","demouser");
        waitFor(4);

        String expectedUrl = "https://www.phptravels.net/account/";
        String actualUrl = accountPage.getCurrentUrl();
        Assert.assertEquals(actualUrl, expectedUrl, "Incorrect URL");
    }
    private void waitFor(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }
    }
    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        phpTravelsApp.close();
    }
}
