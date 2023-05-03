package PagesObjectsModels;

import Common.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderPage extends BasePage {

    public OrderPage(WebDriver driver) {
        super(driver);
    }

    By actionButtonBy = By.cssSelector(".order-actions .button");
    /**
     * This method help to assert that we are on order page
     * @return true if the action button is clickable
     */
    public boolean isActionButtonEnabled() {
        return driver.findElement(actionButtonBy).isEnabled();
    }

    By billingTitleDetailsBy = By.cssSelector(".woocommerce-billing-fields h3");

    /**
     * help to assert that we are in order page after clicking on PROCEED CHECKOUT
     * @return true if title is displayed
     */
    public boolean isBillingDetailsTitleDisplayed() {
        return driver.findElement(billingTitleDetailsBy).isDisplayed();
    }
}
