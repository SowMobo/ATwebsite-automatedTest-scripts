package Common;

import PagesObjectsModels.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Header {
    public WebDriver driver;
    public Header(WebDriver driver) {
        this.driver = driver;
        // Often we will use PageFactor to make some sections of code more readable
        PageFactory.initElements(driver, this);
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

    @FindBy(id = "text-22-sub_row_1-0-1-1-0")
        private WebElement newArrival;
    /**
     * This method verify whether we are on Home page
     * @return true if the element NewArrival is present
     */
    public boolean isNewArrivalsDisplayed() {
        return newArrival.isDisplayed();
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
        //this.closePopup();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.findElement(linkBasketBy).click();
        return new BasketPage(driver);
    }
}
