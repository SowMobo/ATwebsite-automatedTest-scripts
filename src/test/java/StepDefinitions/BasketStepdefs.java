package StepDefinitions;

import PagesObjectsModels.AuthenticationPage;
import PagesObjectsModels.BasketPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class BasketStepdefs {

    WebDriver driver = Hook.driver;
    private BasketPage basket;

    public BasketStepdefs() {
        basket = new BasketPage(driver);
    }

    @Then("le button PROCEED TO CHECKOUT est cliquable")
    public void leButtonPROCEEDTOCHECKOUTEstCliquable() {
        Assert.assertTrue(basket.isProccedToCheckoutButtonEnabled());
    }

    @Then("le titre du produit est correct {string}")
    public void leTitreDuProduitEstCorrect(String arg0) {
        Assert.assertEquals(arg0, basket.getTitle());
    }

    @And("le prix est correct {string}")
    public void lePrixEstCorrect(String arg0) {
        Assert.assertEquals(arg0, basket.getSubtotal());
    }


    @And("je clcik sur le button UPDATE BASKET")
    public void jeClcikSurLeButtonUPDATEBASKET() {
        basket.updateBasket();
    }

    @Then("le prix total est correct {string}")
    public void lePrixTotalEstCorrect(String arg0) {
        Assert.assertEquals(arg0, basket.getSubtotal());
    }

    @And("je augmente la quantite {string}")
    public void jeAugmenteLaQuantite(String arg0) {
        basket.increaseQtyBy(arg0);
//        try {
//            Thread.sleep(2000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
    }
}
