package StepDefinitions;

import PagesObjectsModels.ProductPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class Productstepdefs {
    WebDriver driver = Hook.driver;
    private ProductPage product;
    public Productstepdefs() {
        product = new ProductPage(driver);
    }

    @And("je click sur le logo AT depuis la page product")
    public void jeClickSurLeLogoATDepuisLaPageProduct() {
        product.openHomePage();
    }

    @Then("le titre Product Description est affichee")
    public void leTitreProductDescriptionEstAffichee() {
        Assert.assertTrue(product.isProductDescriptionDisplayed());
    }

    @And("je click sur le button VIEW BASKET")
    public void jeClickSurLeButtonVIEWBASKET() {
        product.openCartPage();
    }

    @And("je click le button ADD TO BASKET depuis la page produit")
    public void jeClickLeButtonADDTOBASKETDepuisLaPageProduit() {
        product.addToBasket();
    }
}
