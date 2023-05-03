package PagesObjectsModels;

import Common.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ShopPage extends BasePage {

    public ShopPage(WebDriver driver) {
        super(driver);
    }

    By productCategoriesFilterBy = By.cssSelector(".product-categories a");

    /**
     * this filter shop items by product category
     *
     * @param productCategoryIndex
     */
    private void filterBy(int productCategoryIndex) {
        driver.findElements(productCategoriesFilterBy).get(productCategoryIndex).click();
    }

    /**
     * filter products by Android products
     *
     * @return
     */
    public ShopPage displayAndroidProducts() {
        this.filterBy(0);
        return this;
    }

    /**
     * filter products by HTML products
     *
     * @return a Shop page object
     */
    public ShopPage displayHTMLProducts() {
        this.filterBy(1);
        return this;
    }

    /**
     * filter products by Javascript products
     *
     * @return a Shop page object
     */
    public ShopPage displayJavascriptProducts() {
        this.filterBy(2);
        return this;
    }

    /**
     * filter products by selenium products
     *
     * @return a Shop page object
     */
    public ShopPage displaySeleniumProducts() {
        this.filterBy(3);
        return this;
    }

    By priceFilterBy = By.name("orderby");

    /**
     * sort shop items by price using a select web element
     *
     * @param order
     */
    private void sortByPrice(String order) {
        Select priceSorterTag = new Select(driver.findElement(priceFilterBy));
        priceSorterTag.selectByValue(order);
    }

    public ShopPage sortByPriceLowToHigh() {
        this.sortByPrice("price");
        return this;
    }

    public ShopPage sortByPriceHighToLow() {
        this.sortByPrice("price-desc");
        return this;
    }

    By productBy = By.cssSelector(".products.masonry-done li");
    By productPriceBy = By.cssSelector("a span.price");

    /**
     * Open Product page to view product details by interacting with product items.
     * A SCROLL DOWN action is required to get out ads
     * A sleep is also required here because implicit and explicit wait do not work.
     * With a implicit and explicit wait, an ElementClickIntercepted is thrown because
     * a another element (ad) may receive the click
     *
     * @param productIndex
     * @return a Product Page object
     */
    private WebElement getProductBy(int productIndex) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Actions action = new Actions(driver);
        // scroll down
        action.sendKeys(Keys.PAGE_DOWN).build().perform();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return driver.findElements(productBy).get(productIndex);
    }

    public String getProductPriceBy(int productIndex) {
        return getProductBy(productIndex)
                .findElement(productPriceBy)
                .getText();
    }
    public ProductPage openProductPageByPhotoLink(int productIndex) {
        getProductBy(productIndex).findElement(By.cssSelector("a img")).click();
        return new ProductPage(driver);
    }

    public ProductPage openProductPageByDescriptionLink(int productIndex) {
        getProductBy(productIndex).findElement(By.cssSelector("a h3")).click();
        return new ProductPage(driver);
    }

    public ProductPage openProductPageByPriceLink(int productIndex) {
        getProductBy(productIndex).findElement((productPriceBy)).click();
        return new ProductPage(driver);
    }

    By addToBasketBy = By.cssSelector("a.add_to_cart_button");
    /**
     * Add to cart a product available in stock
     *
     * @return a Shop Page object
     */
    public ShopPage addToBasket() {
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
        driver.findElement(addToBasketBy).click();
        return this;
    }

    By viewBasketBy = By.cssSelector(".added_to_cart.wc-forward");

    /**
     * Open Cart page to proceed to payment
     *
     * @return a Product Page
     */
    public ProductPage openBasket() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(viewBasketBy)).click();
        return new ProductPage(driver);
    }

    public String getDisplayedProductsNumber() {
        Integer num= driver.findElements(productBy).size();
        return num.toString();
    }

}
