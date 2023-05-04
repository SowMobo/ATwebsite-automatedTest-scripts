package PagesObjectsModels;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class UserEmailAccountPage {
    public WebDriver driver;

    public UserEmailAccountPage(WebDriver driver) {
        this.driver = driver;
    }

    By numberOfEmailReceivedBy = By.xpath("#nbmail");

    public UserEmailAccountPage getFirstEmail() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(numberOfEmailReceivedBy)).click();
        return this;
    }

    public String getNumberOfEmailReceived() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
//        WebDriverWait  wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return driver.findElement(numberOfEmailReceivedBy).getText();
    }
        public UserEmailAccountPage openMyEmailInBox (String email){
            driver.findElement(By.cssSelector("input.ycptinput")).sendKeys(email + Keys.ENTER);
            return this;
        }
    }
