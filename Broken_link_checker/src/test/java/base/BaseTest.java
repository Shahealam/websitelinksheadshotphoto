package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

public class BaseTest {
    protected WebDriver driver;
    protected String baseUrl = "https://www.headshotphoto.io/";

    @BeforeClass
    public void setUp() {
        // Setup ChromeDriver using WebDriverManager
        WebDriverManager.chromedriver().setup();

        // ChromeOptions for headless mode
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new");         // Use new headless mode (faster, stable)
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--disable-gpu");
        options.addArguments("--window-size=1920,1080"); // Ensure full-screen rendering
        options.addArguments("--disable-notifications");
        options.addArguments("--ignore-certificate-errors");

        // Initialize ChromeDriver
        driver = new ChromeDriver(options);

        // Basic settings
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(baseUrl);

        System.out.println("✅ Browser launched in headless mode");
        System.out.println("🌐 Navigated to: " + baseUrl);
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            System.out.println("🧹 Browser closed successfully");
        }
    }
}
