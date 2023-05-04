package PagesObjectsModels;

import Common.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyAccountPage extends BasePage {

    public MyAccountPage(WebDriver driver) {
        super(driver);
    }
    By myAccountNavigationLinks = By.cssSelector(".woocommerce-MyAccount-navigation-link a");

    /**
     * Open a page from My Account page based on its position in navigation panel on the left
     * @param pageIndex
     */
    private void openAPageFromMyAccountPage(int pageIndex) {
        driver.findElements(myAccountNavigationLinks).get(pageIndex).click();
    }
    /**
     * This method logout user
     * @return a AccountDetailsPage object
     */
    public AuthenticationPage logout() {
        this.openAPageFromMyAccountPage(5);
        return new AuthenticationPage(driver);
    }
    /**
     * This method Account Details Page in order to edit user account information
     * @return a AccountDetailsPage object
     */
    public AccountDetailsPage openAccountDetailsPage() {
        this.openAPageFromMyAccountPage(4);
        this.closePopup();
        return new AccountDetailsPage(driver);
    }

    public OrderPage openOrderPage() {
        this.openAPageFromMyAccountPage(2);
        return new OrderPage(driver);
    }

    /**
     * This method open Address page in order to edit Billing and shipping address
     * @return a AddressPage object
     */
    public AddressPage openAddressPage() {
        this.openAPageFromMyAccountPage(3);
        return new AddressPage(driver);
    }
    /**
     * This method open Downloads page in order to consult Downloads history
     * @return a AddressPage object
     */
    public DownloadsPage openDownloadsPage() {
        this.openAPageFromMyAccountPage(2);
        return new DownloadsPage(driver);
    }

    By welcomeMsg = By.cssSelector("div.woocommerce-MyAccount-content p");
    public String getWelcomeMsg() {
        return driver.findElement(welcomeMsg).getText();
    }
}
