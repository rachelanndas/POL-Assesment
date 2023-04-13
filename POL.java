package pol.bde.utils.api;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class POL {
    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        // Set the ChromeDriver path
        System.setProperty("webdriver.chrome.driver", "C:/Users/rachel.ann.das/Downloads/chromedriver_win32/chromedriver.exe");

        // Launch Chrome browser
        driver = new ChromeDriver();

        // Navigate to Amazon website
        driver.get("https://www.amazon.com/");
    }

    @Test
    public void testSearchProduct() {
        // Find the search bar element
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));

        // Enter the product name "iphone" in the search bar
        searchBox.sendKeys("iphone");

        // Click on the search button
        WebElement searchButton = driver.findElement(By.cssSelector("input.nav-input[value='Go']"));
        searchButton.click();

        // Verify that the first result contains the text "Apple iPhone"
        WebElement firstResult = driver.findElement(By.cssSelector("div[data-index='0'] h2 a span"));
        Assert.assertTrue(firstResult.getText().contains("Apple iPhone"), "First search result does not contain 'Apple iPhone'");

    }
}

