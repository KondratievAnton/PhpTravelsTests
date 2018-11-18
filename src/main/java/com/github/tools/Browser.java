package com.github.tools;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.EdgeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import io.github.bonigarcia.wdm.OperaDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.safari.SafariDriver;
import ru.yandex.qatools.allure.annotations.Step;

public class Browser {
    public static WebDriver instance;
    public Browser() {
    }
    public static WebDriver open() {
        WebDriver driver = startBrowser();
        driver.manage().window().maximize();
        return driver;
    }
    private static WebDriver startBrowser() {
        String browser = System.getProperty("browser");
        WebDriver driver;
        if (browser == null || "chrome".equals(browser.toLowerCase())) {
            driver = startChrome();
        } else if ("firefox".equals(browser.toLowerCase())) {
            driver = startFirefox();
        } else if ("edge".equals(browser.toLowerCase())) {
            driver = startEdge();
        } else if ("opera".equals(browser.toLowerCase())) {
            driver = startOpera();
        } else  if ("explorer".equals(browser.toLowerCase())) {
            driver = startExplorer();
     //   } else if ("safari".equals(browser.toLowerCase())) {
     //       driver = startSafari();
        } else
            throw new RuntimeException("\nUnsupported driver for browser: " + browser + "\n");
        return driver;
    }
    @Step("Start chrome")
    public static WebDriver startChrome() {
        ChromeDriverManager.getInstance().setup();
        instance = new ChromeDriver();
        return instance;
    }
    @Step("Start firefox")
    public static WebDriver startFirefox() {
        FirefoxDriverManager.getInstance().setup();
        instance = new FirefoxDriver();
        return instance;
    }
    @Step("Start edge")
    public static WebDriver startEdge() {
        EdgeDriverManager.getInstance().setup();
        instance = new EdgeDriver();
        return instance;
    }
    @Step("Start opera")
    public static WebDriver startOpera() {
        OperaDriverManager.getInstance().setup();
        instance = new OperaDriver();
        return  instance;
    }
    @Step("Start explorer")
    public static WebDriver startExplorer() {
        OperaDriverManager.getInstance().setup();
        instance = new InternetExplorerDriver();
        return  instance;
    }
    @Step("Start safari")
    public static WebDriver startSafari() {
        OperaDriverManager.getInstance().setup();
        instance = new SafariDriver();
        return  instance;
    }
}
