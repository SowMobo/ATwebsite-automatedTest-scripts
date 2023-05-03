package PagesObjectsModels;

import Common.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductPage extends BasePage {

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    By productDescriptionTitleBy = By.cssSelector("#tab-description h2");

    public boolean isProductDescriptionDisplayed() {
        return driver.findElement(productDescriptionTitleBy).isDisplayed();
    }

    By productPriceBy = By.cssSelector("td.product-price");

    /**
     * Get actual product price in product page. We will use this result to assert
     * price in shop page
     *
     * @return a String representing the price
     */
    public String getPrice() {
        return driver.findElement(productPriceBy).getText();
    }

    By titleBy = By.xpath("//div/h1");

    /**
     * Get actual product title in product page. We will use this result to assert
     * title in shop page
     *
     * @return a String representing the title
     */
    public String getTitle() {
        return driver.findElement(titleBy).getText();
    }

    By addToBasketBy = By.cssSelector(".single_add_to_cart_button");

    /**
     * Add a product to cart to order later
     * @return a Product object
     */
    public ProductPage addToBasket() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(addToBasketBy)).click();
        return this;
    }

    By viewBasketBy = By.cssSelector(".button.wc-forward");
    public BasketPage openCartPage() {
        driver.findElement(viewBasketBy).click();
        return new BasketPage(driver);
    }

    By noticeMgsBy = By.cssSelector(".woocommerce-message");
    public ProductPage getNoticeMgs() {
        driver.findElement(noticeMgsBy).getText();
        return this;
    }

}
