package com.example; // Set the correct package name

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MySeleniumTest {

    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        // Set the path to the ChromeDriver executable
        System.setProperty("webdriver.chrome.driver",
                "\\C:\\Users\\kamo's hunny\\Desktop\\JunitTests\\ChmDRiver\\chromedriver-win64\\chromedriver.exe\\");

        // Initialize the WebDriver instance (in this case, ChromeDriver)
        driver = new ChromeDriver();
    }

    @Test
    public void MyCheckboxAssertion() {
        // Navigate to a website
        driver.get("https://lambdatest.github.io/sample-todo-app/");

        LocalDate TimeOfExecution = LocalDate.of(2023, 10, 26);
        DateTimeFormatter JustAdateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String dateTotype = JustAdateFormat.format(TimeOfExecution);

        WebElement EntryField = driver.findElement(By.id("sampletodotext"));
        EntryField.sendKeys(dateTotype);

        WebElement AddBtn = driver.findElement(By.id("addbutton"));
        AddBtn.click();

        List<WebElement> Checkboxes = driver.findElements(By.xpath("//li[@ng-repeat]/input "));

        Checkboxes.get(2).click();

        List<WebElement> TodoInfo = driver.findElements(By.xpath("//li[@ng-repeat]/span"));
        Assertions.assertEquals("2023-10-26", TodoInfo.get(5).getText());

        // Example: Assert the page title
        String pageTitle = driver.getTitle();
        // Add your assertion logic here

        // Close the WebDriver
        driver.quit();
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
        // Close the WebDriver after each
    }
}