package Common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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
    public Footer enterAnEmailToSubscribe(String email) {
        driver.findElement(subscribeTextBoxBy).sendKeys(email);
        return this;
    }
    By subscribeButtonBy = By.xpath("//input[@value='Subscribe']");
    public Footer subscribeToATNewsletter() {
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
}
