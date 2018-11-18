package com.github.authorization;

import com.github.phptravels.AccountPage;
import com.github.phptravels.LoginPage;
import com.github.phptravels.PhpTravelsApp;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class LoginTest {
    private PhpTravelsApp phpTravelsApp = new PhpTravelsApp();
    private LoginPage loginPage;
    private AccountPage accountPage;

    @Test
    public void testLogin() {
        loginPage = phpTravelsApp.openLoginPage();
        accountPage = loginPage.loginAs("user@phptravels.com","demouser" );
        waitFor(4);

        String expectedUrl = "https://www.phptravels.net/account/";
        String actualUrl = accountPage.getCurrentUrl();
        Assert.assertEquals(actualUrl, expectedUrl, "Incorrect URL");

        //String actualUsernameOnHeader = accountPage.readUserName();
        //Assert.assertEquals(actualUsernameOnHeader, "JOHNY", "Incorrect Username");
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