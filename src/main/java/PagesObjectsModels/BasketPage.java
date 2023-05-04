package PagesObjectsModels;

import Common.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class BasketPage extends BasePage {

    public BasketPage(WebDriver driver) {
        super(driver);
    }

    By quantityBy = By.cssSelector("input.input-text[value]");

    /**
     * select quantity to order
     * @param qty
     * @return a shop page object
     */
    public ShopPage setQuantity(String qty) {
        driver.findElement(quantityBy).sendKeys(qty);
        return new ShopPage(driver);
    }

    By upDownqtySelectorBy = By.name("cart[9766527f2b5d3e95d4a733fcfb77bd7e][qty]");
    private WebElement upDownQtySelect() {
        return  driver.findElement(upDownqtySelectorBy);
    }

    public BasketPage increaseQtyBy(String qty) {
        String initValue = upDownQtySelect().getAttribute("value");
        for(int i=0; i < Integer.parseInt(qty); ++i) {
//            try {
//                Thread.sleep(2000);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
            upDownQtySelect().sendKeys(Keys.ARROW_UP);
        }
        return this;
    }
    public BasketPage decreaseQtyBy(String qty) {
        String initValue = upDownQtySelect().getAttribute("value");
        for(int i=0; i < Integer.parseInt(qty); ++i) {
//            try {
//                Thread.sleep(2000);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
            upDownQtySelect().sendKeys(Keys.ARROW_DOWN);
        }
        return this;
    }
    By titleBy = By.cssSelector("td.product-name");
    public String getTitle() {
        return driver.findElement(titleBy).getText();
    }

    By subtotalBy = By.xpath("//td[@data-title='Subtotal']");
    public String getSubtotal() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return driver.findElement(subtotalBy).getText();
    }

    By taxBy = By.xpath("//td[@data-title='Tax']");
    public String getTax() {
        return driver.findElement(taxBy).getText();
    }

    By proceedButtonBy = By.cssSelector(".checkout-button");
    public OrderPage openOrderPage() {
        driver.findElement(proceedButtonBy).click();
        return new OrderPage(driver);
    }

    public boolean isProccedToCheckoutButtonEnabled() {
        return driver.findElement(proceedButtonBy).isEnabled();
    }

    By updateBasketBy = By.name("update_cart");
    public BasketPage updateBasket() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.findElement(updateBasketBy).click();
        return this;
    }

}
