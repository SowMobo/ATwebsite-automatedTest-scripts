package Common;

import PagesObjectsModels.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

    public WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        // Often we will use PageFactor to make some sections of code more readable
        PageFactory.initElements(driver, this);
    }

    public HomePage openSUT() {
        //open the system under test once the driver is instantiated
        driver.get("https://practice.automationtesting.in");
        return new HomePage(driver);
    }
    By dismissAdButtonBy = By.cssSelector("#dismiss-button");
    /**
     * This method walks through two iframes to close ad and switches back to default next Page
     */
    public void closeAd() {
//        driver.switchTo().frame("aswift_7_host");
        driver.switchTo().frame("aswift_7");
        driver.switchTo().frame("ad_iframe");
        driver.findElement(dismissAdButtonBy).click();
        driver.switchTo().defaultContent();
    }

    By htmlBy = By.tagName("html");
    public void closePopup() {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(htmlBy));
        actions.moveByOffset(-400, 0).click().build().perform();
    }
    By subscribeTextBoxBy = By.name("EMAIL");

    /**
     * This method find and enter an email to be subscribed to AT newsletter
     * @param email
     * @return a Footer object
     */
    public BasePage enterAnEmailToSubscribe(String email) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Actions action = new Actions(driver);
        // scroll down
        action.sendKeys(Keys.PAGE_DOWN).build().perform();
        action.sendKeys(Keys.PAGE_DOWN).build().perform();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.findElement(subscribeTextBoxBy).sendKeys(email);
        return this;
    }
    By subscribeButtonBy = By.xpath("//input[@value='Subscribe']");
    public BasePage subscribeToATNewsletter() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Actions action = new Actions(driver);
        // scroll down
        action.sendKeys(Keys.PAGE_DOWN).build().perform();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.findElement(subscribeButtonBy).click();
        return this;
    }
    By invalidEmailErrorMessage = By.cssSelector(".mc4wp-response");

    /**
     * This method get the actual error message generated when a user provide an invalid email.
     * This message will be used to asser against the expected error message
     * @return a Footer object
     */
    public String getInvalidEmailErrorMessage() {
        return driver.findElement(invalidEmailErrorMessage).getText();
    }

    /**
     * Get the confirmation message displayed after a success subscription
     */
    public String getSubscriptionConfirmationMsg() {
        return driver.findElement(By.cssSelector(".mc4wp-alert.mc4wp-success")).getText();
    }

    @FindBy(id = "site-logo")
    private WebElement logoAT;
    /**
     * This find and click on site AT logo in order to check the link embedded in it.
     * @return a HomePage object
     */
    public HomePage openHomePage() {
        logoAT.click();
        return new HomePage(driver);
    }


    @FindBy(id = "menu-item-40")
    private WebElement shop;
    /**
     * This method open Shop page to consult products
     * @return a ShopPage object
     */
    public ShopPage openShopPage() {
        shop.click();
        this.closePopup();
        return new ShopPage(driver);
    }
    @FindBy(id = "menu-item-50")
    private WebElement myAccount;
    /**
     * This method find and click on My Account item on header. The resulting open page depend on
     * whether the user is connected or not before clicking.
     * openAuthenticationPage() and openMyAccount() choice between these two outcomes
     */
    private void postRequestToAccessMyAccount() {
        myAccount.click();
    }

    /**
     * This method open My Account  Page
     * @return a new MyAccountPage object
     */
    public MyAccountPage openMyAccountPage() {
        this.postRequestToAccessMyAccount();
        return new MyAccountPage(driver);
    }

    /**
     *  This method find and click on My Account item on header to open authentication Page
     * @return a new AuthenticationPage object
     */
    public AuthenticationPage openAuthenticationPage() {
        this.postRequestToAccessMyAccount();
        this.closePopup();
        return new AuthenticationPage(driver);
    }

    @FindBy(id = "wpmenucartli")
    private WebElement basket;
    public BasketPage openCartPage() {
        basket.click();
        return new BasketPage(driver);
    }

    By linkBasketBy = By.cssSelector("i.wpmenucart-icon-shopping-cart-0");
    public BasketPage openBasketByLogo() {
        this.closePopup();
        driver.findElement(linkBasketBy).click();
        return new BasketPage(driver);
    }
}
