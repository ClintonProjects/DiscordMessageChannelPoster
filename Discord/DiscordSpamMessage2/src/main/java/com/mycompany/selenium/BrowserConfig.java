package com.mycompany.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BrowserConfig {

    public static boolean forumBump = false;
    public static WebDriver driver;
    public static String browser;

    public static void driverGet(String link) {
        driver.get(link);
    }

    public static void findXpathSendKey(String xpath, String keys) throws InterruptedException {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 60);
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            element.sendKeys(keys);
        } catch (Exception e) {
        }
    }

    public static void findXpathClick(String xpath) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 60);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        element.click();
    }

    public static boolean elementExists(String xpath) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 60);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        return element.isDisplayed();
    }

    public static void setBrowserConfig() {
        try {
            System.out.println("Browser opened");
            browser = "googlechrome";
            if (browser.contains("googlechrome")) {
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--headless");
                options.addArguments("--start-maximized");
                String path = "drivers\\chromedriver.exe";
                System.out.println(path);

                System.setProperty("webdriver.chrome.driver", "SupportingFiles\\chromedriver.exe");
                driver = new ChromeDriver(options);
            }
        } catch (Exception e) {
            System.out.println("Error with set browser Config");
            System.out.println(e);
        }
    }

    public static void driverClose() {
        driver.close();
    }
}
