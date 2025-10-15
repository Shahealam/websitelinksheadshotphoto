package Headshotphoto;



import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import test.Homepage;

public class HomepageTests extends BaseTest {

    @Test(priority = 1, description = "Verify homepage title and logo visibility")
    public void verifyHomePageTitleAndLogo() {
        Homepage hp = new Homepage(driver);
        Assert.assertTrue(hp.verifyLogoVisible(), "Logo is not visible!");
        Assert.assertTrue(hp.verifyPageTitle("Headshot Photo"), "Homepage title mismatch!");
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
