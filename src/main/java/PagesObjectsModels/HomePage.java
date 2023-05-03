package PagesObjectsModels;

import Common.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }
    By newArrivalsBy = By.cssSelector("#text-22-sub_row_1-0-1-1-0 h2");
    public boolean isNewArrivalsDisplayed() {
        return driver.findElement(newArrivalsBy).isDisplayed();
    }
}
