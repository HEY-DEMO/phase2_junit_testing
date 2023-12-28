package Junit_facebook_google.unit_testing_facebook_google;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import static org.junit.Assert.assertTrue;

public class facebook {

    private WebDriver driver;

    @Before
    public void setUp() {
        // Set the path to the ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "drivers/msedgedriver");

        // Initialize ChromeDriver
        driver = new EdgeDriver();
    }

    @Test
    public void testFacebookLogin() {
        // Open Facebook login page
        driver.get("https://www.facebook.com");

        // Find the email and password input fields and the login button
        WebElement emailInput = driver.findElement(By.id("email"));
        WebElement passwordInput = driver.findElement(By.id("pass"));
        WebElement loginButton = driver.findElement(By.name("login"));

        // Enter your Facebook credentials
        emailInput.sendKeys("your_email@example.com");
        passwordInput.sendKeys("your_password");

        // Click the login button
        loginButton.click();

        // Wait for the login process to complete
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Check if login was successful (you may need to adjust the condition based on your specific scenario)
        assertTrue(driver.getCurrentUrl().contains("https://www.facebook.com/"));
    }

    @After
    public void tearDown() {
        // Close the browser
        driver.quit();
    }
}