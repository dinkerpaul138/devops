import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("Starting Selenium program...");
        
        // Set ChromeDriver path
        System.setProperty("webdriver.chrome.driver", "/home/kali/selenium/bin/chromedriver");
        
        // Configure Chrome options
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        // Uncomment below for headless mode
        // options.addArguments("--headless");
        
        WebDriver driver = new ChromeDriver(options);
        
        try {
            driver.get("https://www.google.com");
            System.out.println("Opened Google homepage.");
            
            WebElement searchBox = driver.findElement(By.name("q"));
            searchBox.sendKeys("Selenium WebDriver tutorial");
            searchBox.submit();
            System.out.println("Performed search operation.");
            
            Thread.sleep(2000);
            
            String pageTitle = driver.getTitle();
            System.out.println("Title of the results page: " + pageTitle);
        } finally {
            driver.quit();
            System.out.println("Browser closed. Program completed.");
        }
    }
}
