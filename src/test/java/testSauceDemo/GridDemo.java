package testSauceDemo;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.HasDevTools;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import testBase.BrowserManager;

public class GridDemo {

    WebDriver driver = null;

    @Test
    public void testSeleniumGrid() {
        ChromeOptions options = new ChromeOptions();
        try {
            driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), options);
        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        driver.get("https://www.google.com");
        System.out.println("Title: " + driver.getTitle());

        driver.quit();

    }

    @Test
    public void openShadowDomElementTest()

    {
        ChromeOptions options = new ChromeOptions();
        try {
            driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), options);
        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        driver.get("https://letcode.in/shadow");

        // Locate the shadow host element
        WebElement shadowHost = driver.findElement(By.id("open-shadow"));

        // Access the shadow root
        SearchContext shadowRoot = shadowHost.getShadowRoot();

        // Interact with elements inside the shadow DOM
        WebElement inputElement = shadowRoot.findElement(By.cssSelector("input#fname"));
        inputElement.sendKeys("John Doe");
        driver.quit();
    }

  
}
