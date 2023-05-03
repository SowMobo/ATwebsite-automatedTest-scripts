package PagesObjectsModels;

import Common.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class AccountDetailsPage extends BasePage {

    public AccountDetailsPage(WebDriver driver) {
        super(driver);
    }

    By currentPasswordTextBoxBy = By.id("password_current");
    public AccountDetailsPage enterCurrentPassword(String currentPassword) {
        driver.findElement(currentPasswordTextBoxBy).sendKeys(currentPassword);
        return this;
    }

    By newPasswordTextBoxBy = By.id("password_1");
    public AccountDetailsPage enterNewPassword(String newPassword) {
        driver.findElement(newPasswordTextBoxBy).sendKeys(newPassword);
        return this;
    }

    By confirmNewPasswordTextBoxBy = By.id("password_2");
    public AccountDetailsPage confirmNewPassword(String newPasswordConfirm) {
        driver.findElement(confirmNewPasswordTextBoxBy).sendKeys(newPasswordConfirm + Keys.ENTER);
        return this;
    }
    //Your current password is incorrect.
    //New passwords do not match.
    By saveChangesButtonBy = By.cssSelector(".woocommerce-Button.button");
    public AccountDetailsPage saveChanges() {
        driver.findElement(saveChangesButtonBy).click();
        return new AccountDetailsPage(driver);
    }

    By failChangePasswordErrorMsgBy = By.cssSelector(".woocommerce-error");
    public String getFailChangePasswordErrorMsg() {
        return driver.findElement(failChangePasswordErrorMsgBy).getText();
    }

    By saveChangeButtonBy = By.cssSelector(".button[type='submit']");
    public boolean isSaveChangeButtonDisabled() {
        return driver.findElement(saveChangeButtonBy).isEnabled();
    }

    By passwordStrengthHintMsg = By.cssSelector(".woocommerce-password-strength.bad");
    public boolean isPasswordStrengthMsgDisplayed() {
        return driver.findElement(passwordStrengthHintMsg).isDisplayed();
    }

    By passwordHintBy = By.cssSelector(".woocommerce-password-hint");
    public boolean isPasswordHintDisplayed() {
        return driver.findElement(passwordHintBy).isDisplayed();
    }
}
