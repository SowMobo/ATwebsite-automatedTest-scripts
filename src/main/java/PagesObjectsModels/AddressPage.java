package PagesObjectsModels;

import Common.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddressPage extends BasePage {

    public AddressPage(WebDriver driver) {
        super(driver);
    }

    By billingAddressTitieleBy = By.cssSelector(".woocommerce-Address-title.title");
    public boolean isBillingAddressTitleDisplayed() {
        return driver.findElement(billingAddressTitieleBy).isDisplayed();
    }
}
