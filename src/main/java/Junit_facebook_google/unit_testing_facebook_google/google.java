package Junit_facebook_google.unit_testing_facebook_google;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class google {

    private WebDriver driver;

    @Before
    public void setUp() {
        // Set up the WebDriver (in this example, using Chrome)
        System.setProperty("webdriver.chrome.driver", "drivers/msedgedriver.exe");
        driver = new EdgeDriver();
    }

    @Test
    public void testGoogleSearch() {
        // Navigate to Google
        driver.get("https://www.google.com");

        // Find the search box using its name attribute value
        WebElement searchBox = driver.findElement(By.name("q"));

        // Type the search query
        searchBox.sendKeys("roblox");

        // Submit the form
        searchBox.submit();

        // Wait for the results page to load (you may need to use WebDriverWait)
        // Here, we'll use a simple sleep, but in a real scenario, you should use WebDriverWait
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Assert that the search results page title contains the search query
        String pageTitle = driver.getTitle();
        assert pageTitle.contains("roblox - Google Search") : "Search results page title does not contain the search query";
    }

    @After
    public void tearDown() {
        // Close the browser
        driver.quit();
    }
}
