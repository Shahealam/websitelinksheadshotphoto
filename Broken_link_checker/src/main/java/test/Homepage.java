package test;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class Homepage {
    WebDriver driver;
    WebDriverWait wait;

    public Homepage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Header elements
    @FindBy(css = "img[alt='Headshot Photo']")
    WebElement logo;

    @FindBy(linkText = "Pricing")
    WebElement pricingLink;

    @FindBy(linkText = "FAQ")
    WebElement faqLink;

    @FindBy(linkText = "Reviews")
    WebElement reviewsLink;

    @FindBy(css = "a[href*='create']")
    WebElement createHeadshotButton;

    // Hero section
    @FindBy(xpath = "//h1[contains(text(),'Professional Business Headshots')]")
    WebElement heroHeading;

    @FindBy(xpath = "//button[contains(text(),'Try Free Demo')]")
    WebElement tryFreeDemoButton;

    @FindBy(xpath = "//button[contains(text(),'Start My Headshots')]")
    WebElement startMyHeadshotsButton;

    // Methods for actions
    public boolean verifyHeroHeading() {
        wait.until(ExpectedConditions.visibilityOf(heroHeading));
        return heroHeading.isDisplayed();
    }

    public void clickPricingLink() {
        pricingLink.click();
    }

    public void clickFAQLink() {
        faqLink.click();
    }

    public void clickCreateHeadshot() {
        createHeadshotButton.click();
    }

    public boolean verifyLogoVisible() {
        return logo.isDisplayed();
    }

    public boolean verifyPageTitle(String expectedTitle) {
        return driver.getTitle().contains(expectedTitle);
    }
}
