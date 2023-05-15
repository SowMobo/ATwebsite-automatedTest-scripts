package Common;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class Footer {
    public WebDriver driver;

    public Footer(WebDriver driver) {
        this.driver = driver;
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
        return new BasePage(driver);
    }

    By subscribeButtonBy = By.xpath("//input[@value='Subscribe']");
    public Footer subscribeToATNewsletter() {
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
    By errorMsgBy = By.cssSelector("div.mc4wp-alert.mc4wp-error");
    By successMsgBy = By.cssSelector(".mc4wp-alert.mc4wp-success");
    public String getSubscriptionConfirmationMsg() {
        return driver.findElement(errorMsgBy).getText();
    }
}
