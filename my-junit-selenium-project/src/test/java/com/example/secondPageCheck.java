package com.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class secondPageCheck {
    private WebDriver driver;

    public void SeconPageStarting() {

        System.setProperty("webdriver.chrome.driver","C:\\Users\\kamo's hunny\\Desktop\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://www.facebook.com/");
        String Username = "0763577766";
        String Password = "52664356Trox"; // Correct password

        WebElement UsernameEntryBox = driver.findElement(By.id("email"));
        UsernameEntryBox.sendKeys(Username);

        WebElement PasswordEntryBox = driver.findElement(By.id("pass"));
        PasswordEntryBox.sendKeys(Password);

        WebElement LoginBtn = driver.findElement(By.name("login"));
        LoginBtn.click();
        WebDriverWait wait = new WebDriverWait(driver, 10);

        if (driver != null) {
            try {
                // Add a 8-second (8000 milliseconds) sleep before closing the browser
                Thread.sleep(8000);
            } catch (InterruptedException e) {
                System.err.println("Error while waiting: " + e.getMessage());
            }
            driver.quit();

        }
    }
}
