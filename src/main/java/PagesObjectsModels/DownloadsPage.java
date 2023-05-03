package PagesObjectsModels;

import Common.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DownloadsPage extends BasePage {

    public DownloadsPage(WebDriver driver) {
        super(driver);
    }
    By actionButtonBy = By.cssSelector(".woocommerce-Button.button");
    /**
     * This method help to assert that we are on order page
     * @return true if the action button is clickable
     */
    public boolean isActionButtonEnabled() {
        return driver.findElement(actionButtonBy).isEnabled();
    }
}
