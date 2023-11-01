package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.TimeoutException;

public class TutorialPoint {
    private WebDriver driver;

    @BeforeEach
    /*
     * public void Setup() {
     * System.setProperty(
     * "webdriver.chrome.driver","C:\\Users\\kamo's hunny\\Desktop\\chromedriver-win64\\chromedriver.exe"
     * );
     * driver = new ChromeDriver();
     * driver.manage().window().maximize();
     * driver.navigate().to("https://www.facebook.com/");
     * }
     */

    @Test
    public void TitleVerification() {
        try {
            System.out.println("Title verification");

            String title = driver.getTitle();

            String expectedTitle = "Facebook – log in or sign up"; // expected title from the page

            assertEquals(expectedTitle, title, "Title mismatch");

            if (expectedTitle.equals(expectedTitle)) {
                System.out.println("title Verified");
            }

            System.out.println("Title verified");
        } catch (Exception e) {
            System.err.println("No Such title in this webpage");
        }
    }

    @Test
    public void LoginValidation() {
        try {
            String Username = "0763577766";
            String Password = "52664356"; // Correct password

            WebElement UsernameEntryBox = driver.findElement(By.id("email"));
            UsernameEntryBox.sendKeys(Username);

            WebElement PasswordEntryBox = driver.findElement(By.id("pass"));
            PasswordEntryBox.sendKeys(Password);

            WebElement LoginBtn = driver.findElement(By.name("login"));
            LoginBtn.click();

            if (driver != null) {

                WebDriverWait wait = new WebDriverWait(driver, 10); // Adjust the timeout as needed
                try {

                    WebElement dashboardElement = wait
                            .until(ExpectedConditions.visibilityOfElementLocated(By.id("dashboard")));

                    assertTrue(dashboardElement.isDisplayed(), "Dashboard element not displayed");
                } catch (TimeoutException e) {

                    WebElement alertElement = driver.findElement(
                            By.xpath("/html/body/div[1]/div[1]/div[1]/div/div[2]/div[2]/form/div/div[1]/div[2]"));
                    assertTrue(alertElement.isDisplayed(), "Alert message is not displayed");
                    String alertText = alertElement.getText();
                    assertEquals(
                            "The email address or mobile number you entered isn't connected to an account. Find your account and log in.",
                            alertText);
                }
            }
        } catch (Exception e) {
            System.err.println("Exception occurred: " + e.getMessage());
        }

    }

    @Test
    public void PageFunctionalityAssertions() {
        WebStarting StartingWeb = new WebStarting();
        StartingWeb.UrlStarting();
        try {
            WebDriverWait wait = new WebDriverWait(driver, 10);

            WebElement NavbBarWait = wait.until(ExpectedConditions.elementToBeClickable(By.id("yourElementId")));

            // Perform assertions or interactions with the NavbBar element here
            assertTrue(NavbBarWait.isDisplayed(), "NavbBar is not displayed");
        } catch (NoSuchElementException e) {
            fail("NavbBar element not found: " + e.getMessage());
        }
    }

    @Test
    public void LogedInPage() {
        secondPageCheck RunWebBrowser = new secondPageCheck();

        RunWebBrowser.SeconPageStarting();
        WebDriverWait wait = new WebDriverWait(driver, 10);

        // Use the expected conditions to wait for the element to be clickable
        WebElement PostBar = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
                "/html/body/div[1]/div/div[1]/div/div[3]/div/div/div/div[1]/div[1]/div/div[1]/div/div/div[1]/div/div/div[1]/ul/li/div/a/div[1]/div[2]/div/div/div/div/span/span")));

        // Perform your action on the PostBar element (e.g., click)
        PostBar.click();

        driver.quit();
    }
}
