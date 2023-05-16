package PagesObjectsModels;

import Common.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AuthenticationPage extends BasePage {

    public AuthenticationPage(WebDriver driver) {
        super(driver);
    }

    By usernameTextBox = By.id("username");

    /**
     * This method enter username or email to login
     *
     * @param usernameOrEmail
     * @return a AuthenticationPage object
     */
    public AuthenticationPage enterUsernameOrEmail(String usernameOrEmail) {
        driver.findElement(usernameTextBox).sendKeys(usernameOrEmail);
        return this;
    }

    By passwordTextBox = By.id("password");

    /**
     * This method enter a password to login
     *
     * @param password
     * @return a AuthenticationPage object
     */
    public AuthenticationPage enterPassword(String password) {
        driver.findElement(passwordTextBox).sendKeys(password);
        return this;
    }

    By loginButtonBy = By.name("login");

    /**
     * sent username/email and password to request a login.
     * The issue depend on whether credentials are valid or not
     */
    private void postRequestToLogin() {
        driver.findElement(loginButtonBy).click();
    }

    public MyAccountPage openMyAccount() {
        this.postRequestToLogin();
        return new MyAccountPage(driver);
    }

    By loginErrorMessageBy = By.cssSelector(".woocommerce-error");

    /**
     * This method get the error message displayed when the user enter an invalid password
     *
     * @return login error message
     */
    public String getLoginErrorMessage() {
        return driver.findElement(loginErrorMessageBy).getText();
    }

    By rememberMeBy = By.id("rememberme");

    /**
     * This method check Remember Me option in order to allow the app to automatically
     * enter usermane/email for the next login
     *
     * @return a AuthenticationPage object
     */
    public AuthenticationPage rememberMe() {
        driver.findElement(rememberMeBy).click();
        return new AuthenticationPage(driver);
    }

    public MyAccountPage loginWith(String username, String password) {
        return this.openSUT()
                .header.openAuthenticationPage()
                .enterUsernameOrEmail(username)
                .enterPassword(password)
                .openMyAccount();
    }

    By loginTitleBy = By.cssSelector(".col-1 h2");
    public boolean isLoginTitleDisplayed() {
        return driver.findElement(loginTitleBy).isDisplayed();
    }

    By lostPasswordBy = By.cssSelector(".lost_password a");
    public LostPasswordPage openLostPasswordPasswordPage() {
        driver.findElement(lostPasswordBy).click();
        return new LostPasswordPage(driver);
    }
}
