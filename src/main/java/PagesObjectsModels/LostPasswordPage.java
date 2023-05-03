package PagesObjectsModels;

import Common.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class LostPasswordPage extends BasePage {

    public LostPasswordPage(WebDriver driver) {
        super(driver);
    }

    By emailBy = By.id("user_login");
    public LostPasswordPage enterEmail(String email) {
        driver.findElement(emailBy).sendKeys(email);
        return this;
    }

    By resetPasswordBy = By.cssSelector(".woocommerce-Button.button");
    public LostPasswordPage sendResetPasswordLink() {
        driver.findElement(resetPasswordBy).click();
        return this;
    }

    By sentConfirmMsgBy = By.cssSelector("div.woocommerce-message");
    public String getSentConfirmMsg() {
        return driver.findElement(sentConfirmMsgBy).getText();
    }
    By htmlBy = By.tagName("html");
    public void closePopup() {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(htmlBy));
        actions.moveByOffset(-400, 0).click().build().perform();
    }
    public void openUserAccountHomePage(String emailURL) {
        driver.get(emailURL);
        driver.findElement(By.cssSelector("button#accept")).click();
    }

}
