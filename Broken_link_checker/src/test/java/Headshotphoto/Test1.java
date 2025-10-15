/*package Headshotphoto;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Test1 {

    WebDriver driver;

    @BeforeTest
    public void setUp() {
        // Setup ChromeDriver using WebDriverManager
        WebDriverManager.chromedriver().setup();

        // Configure Chrome options
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");  // Run in headless mode
        options.addArguments("--disable-gpu");
        options.addArguments("--window-size=1920,1080");

        // Initialize driver
        driver = new ChromeDriver(options);
    }

    @Test(priority = 1)
    public void testHomePage() {
        // Open Home page
        driver.get("https://www.headshotphoto.io/");

        // Verify page title (replace with actual title)
        String pageTitle = driver.getTitle();
        Assert.assertEquals(pageTitle, "Best AI Headshot Generator for Professional Headshots in 10 minutes."); // Example

        // Verify element (use CSS selector if multiple classes)
        WebElement logo = driver.findElement(By.cssSelector(".max-h-10.w-auto"));
        Assert.assertTrue(logo.isDisplayed(), "Logo is not displayed on Home Page");
    }

    @Test(priority = 2, enabled = false)
    public void testAboutPage() {
        driver.get("https://www.example.com/about");
        String pageTitle = driver.getTitle();
        Assert.assertEquals(pageTitle, "About Us"); // Replace with actual title
        WebElement aboutSection = driver.findElement(By.id("aboutSectionId"));
        Assert.assertTrue(aboutSection.isDisplayed());
    }

    @Test(priority = 3, enabled = false)
    public void testContactPage() {
        driver.get("https://www.example.com/contact");
        String pageTitle = driver.getTitle();
        Assert.assertEquals(pageTitle, "Contact Us"); // Replace with actual title
        WebElement contactForm = driver.findElement(By.id("contactForm"));
        Assert.assertTrue(contactForm.isDisplayed());
    }

    @Test(priority = 4, enabled = false)
    public void testServicesPage() {
        driver.get("https://www.example.com/services");
        String pageTitle = driver.getTitle();
        Assert.assertEquals(pageTitle, "Our Services"); // Replace with actual title
        WebElement servicesList = driver.findElement(By.id("servicesList"));
        Assert.assertTrue(servicesList.isDisplayed());
    }

    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

*/
package Headshotphoto;



import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import test.Homepage;

public class Test1 extends BaseTest {

    @Test(priority = 1, description = "Verify homepage title and logo visibility")
    public void verifyHomePageTitleAndLogo() {
        Homepage hp = new Homepage(driver);
        Assert.assertTrue(hp.verifyLogoVisible(), "Logo is not visible!");
        Assert.assertTrue(hp.verifyPageTitle("Best AI Headshot Generator for Professional Headshots in 10 minutes."), "Homepage title mismatch!");
    }

    @Test(priority = 2, description = "Verify Hero section heading and CTA buttons")
    public void verifyHeroSection() {
        Homepage hp = new Homepage(driver);
        Assert.assertTrue(hp.verifyHeroHeading(), "Hero heading missing!");
    }

    @Test(priority = 3, description = "Verify Pricing page navigation")
    public void verifyPricingNavigation() {
        Homepage hp = new Homepage(driver);
        hp.clickPricingLink();
        Assert.assertTrue(driver.getCurrentUrl().contains("pricing"), "Pricing page not opened!");
        driver.navigate().back();
    }

    @Test(priority = 4, description = "Verify FAQ page navigation")
    public void verifyFAQNavigation() {
        Homepage hp = new Homepage(driver);
        hp.clickFAQLink();
        Assert.assertTrue(driver.getCurrentUrl().contains("faq"), "FAQ page not opened!");
        driver.navigate().back();
    }

    @Test(priority = 5, description = "Verify Create Headshot button redirects correctly")
    public void verifyCreateHeadshotButton() {
        Homepage hp = new Homepage(driver);
        hp.clickCreateHeadshot();
        Assert.assertTrue(driver.getCurrentUrl().contains("create"), "Create Headshot flow not started!");
        driver.navigate().back();
    }
}

