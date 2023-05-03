//import Common.StepDefinitions.Hook;
//import PagesObjectsModels.HomePage;
//import io.github.bonigarcia.wdm.WebDriverManager;
//import org.openqa.selenium.By;
//import org.openqa.selenium.Keys;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.safari.SafariDriver;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.Select;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.Assert;
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.Test;
//
//import javax.swing.*;
//import java.time.Duration;
//
//public class DebugTests {
//    WebDriver driver;
//    @BeforeMethod
//    public void setup() {
//        WebDriverManager.chromedriver().setup();
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--remote-allow-origins=*");
//        options.addArguments("incognito");
//        driver = new ChromeDriver(options);
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
//        driver.manage().window().maximize();
//    }
//    @Test
//    public void debugTest() {
//        driver.get("https://practice.automationtesting.in");
//        By myAccount = By.id("menu-item-50");
//        By  googleIframeBy = By.id("google_esf");
//
//        By aswiftIframeBy = By.cssSelector("iframe#aswift_7");
//        By adIframeBy = By.cssSelector("#ad_iframe[title='Advertisement']");
//        By dismissAdButtonBy = By.cssSelector("#dismiss-button");
//        By usernameTextBox = By.id("username");
//        By passwordTextBox = By.id("password");
//        By loginButtonBy = By.name("login");
//        By myAccountWelcomeMsgBy = By.cssSelector(".woocommerce-MyAccount-content");
//        By loginErrorMessageBy = By.cssSelector(".woocommerce-error");
//        By rememberMeBy = By.id("rememberme");
//        By myAccountNavigationLinks = By.cssSelector(".woocommerce-MyAccount-navigation-link a");
//
////        driver.findElement(myAccount).click();
////
//////        WebElement googleIframe = driver.findElement(googleIframeBy);
//////        driver.switchTo().frame(googleIframe);
////
////        WebElement aswiftIframe = driver.findElement(aswiftIframeBy);
////        driver.switchTo().frame(aswiftIframe);
////
////        WebElement adIframe = driver.findElement(adIframeBy);
////        driver.switchTo().frame(adIframe);
////
////        driver.findElement(dismissAdButtonBy).click();
////        driver.switchTo().defaultContent();
////
////        driver.findElement(usernameTextBox).sendKeys("kdjs@gmail.com");
////
////        driver.findElement(passwordTextBox).sendKeys("kypvu3-mobded-wugcYm");
////        driver.findElement(rememberMeBy).click();
////        driver.findElement(loginButtonBy).click();
//
//        By shopLinkBy = By.id("menu-item-40");
//        driver.findElement(shopLinkBy).click();
//
////        By aswiftShopIframeBy =  By.id("aswift_3");
//        driver.switchTo().frame("aswift_7");
//        driver.switchTo().frame("ad_iframe");
//        driver.findElement(dismissAdButtonBy).click();
//
//        driver.switchTo().defaultContent();
////        driver.findElement(By.id("dropShadowTop")).click();
//        Actions action = new Actions(driver);
//        // scroll down
//        action.sendKeys(Keys.PAGE_DOWN).build().perform();
////        action.sendKeys(Keys.PAGE_DOWN).build().perform();
////        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//        By productBy = By.cssSelector(".products.masonry-done li");
////        try {
////            Thread.sleep(1000);
////        } catch (InterruptedException e) {
////            throw new RuntimeException(e);
////        }
////        WebElement product = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(productBy)).get(0);
////        try {
////            Thread.sleep(5000);
////        } catch (InterruptedException e) {
////            throw new RuntimeException(e);
////        }
//
////        By productDescriptionTitleBy = By.cssSelector("#tab-description h2");
////        Assert.assertTrue(driver.findElement(productDescriptionTitleBy).isDisplayed());
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//        WebElement product = driver.findElements(productBy).get(5);
//        By productByImgLink = By.cssSelector("a img");
//        product.findElement(productByImgLink).click();
////        By addToBasketBy = By.cssSelector("a.add_to_cart_button");
////        driver.findElement(addToBasketBy).click();
//
////        By viewBasketBy = By.cssSelector(".added_to_cart.wc-forward");
////        try {
////            Thread.sleep(1000);
////        } catch (InterruptedException e) {
////            throw new RuntimeException(e);
////        }
////        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
////
////        wait.until(ExpectedConditions.elementToBeClickable(viewBasketBy)).click();
//        By priceBy = By.cssSelector(".entry-summary .price");
//        String actualPrice = driver.findElement(priceBy).getText();
//        System.out.println(actualPrice);
//
//        By titleBy = By.xpath("//div/h1");
//        String actualTitle = driver.findElement(titleBy).getText();
//        System.out.println(actualTitle);
//
//        By addToBasketBy = By.cssSelector(".single_add_to_cart_button");
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//        wait.until(ExpectedConditions.elementToBeClickable(addToBasketBy)).click();
//
//        By noticeMgsBy = By.cssSelector(".woocommerce-message");
//        String noticeMsg = driver.findElement(noticeMgsBy).getText();
//        Assert.assertEquals(noticeMsg, "“Mastering JavaScript” has been added to your basket.");
//
//        By viewBasketBy = By.cssSelector(".button.wc-forward");
//        driver.findElement(viewBasketBy).click();
//
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//
//    }
//
//    @AfterMethod
//    public void teardown() {
//        driver.quit();
//    }
//}
