package Common;

import PagesObjectsModels.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

    public WebDriver driver;
    public Header header;
    public Footer footer;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        header = new Header(driver);
        footer = new Footer(driver);
        // Often we will use PageFactor to make some sections of code more readable
        PageFactory.initElements(driver, this);
    }

    public HomePage openSUT() {
        //open the system under test once the driver is instantiated
        driver.get("https://practice.automationtesting.in");
        return new HomePage(driver);
    }
}
