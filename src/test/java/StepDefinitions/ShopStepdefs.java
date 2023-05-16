package StepDefinitions;

import PagesObjectsModels.ShopPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class ShopStepdefs {
    WebDriver driver = Hook.driver;
    private ShopPage shop;

    public ShopStepdefs() {
        shop = new ShopPage(driver);
    }

    @And("je click sur le premier produit a la Une")
    public void jeClickSurLePremierProduitALaUne() {
        shop.openProductPageByPhotoLink(0);
    }

    @And("je click le button ADD TO BASKET")
    public void jeClickLeButtonADDTOBASKET() {
        shop.addToBasket();
    }

    @And("je click sur le logo BASKET")
    public void jeClickSurLeLogoBASKET() {
        shop.header.openBasketByLogo();
    }

    @And("je click sur la photo du produit")
    public void jeClickSurLaPhotoDuProduit() {
        shop.openProductPageByPhotoLink(0);
    }

    @And("je clique sur la photo de un disponible")
    public void jeCliqueSurLaPhotoDeUnDisponible() {
        shop.openProductPageByPhotoLink(0);
    }

    @And("je click sur le lien HTML")
    public void jeClickSurLeLienHTML() {
        shop.displayHTMLProducts();
    }

    @Then("le nombre d'ouvrages affichee est correct {string}")
    public void leNombreDOuvragesAfficheeEstCorrect(String arg0) {
        Assert.assertEquals(arg0, shop.getDisplayedProductsNumber());
    }

    @And("je click sur le lien ANDROID")
    public void jeClickSurLeLienANDROID() {
        shop.displayAndroidProducts();
    }

    @And("je click sur le lien JAVASCRIPT")
    public void jeClickSurLeLienJAVASCRIPT() {
        shop.displayJavascriptProducts();
    }

    @And("je click sur le lien SELENIUM")
    public void jeClickSurLeLienSELENIUM() {
        shop.displaySeleniumProducts();
    }

    @And("je je select le filtre price Low to High")
    public void jeJeSelectLeFiltrePriceLowToHigh() {
        shop.sortByPriceLowToHigh();
    }

    @Then("le prix du premier ouvrage est correct {string}")
    public void lePrixDuPremierOuvrageEstCorrect(String arg0) {
        Assert.assertEquals(arg0, shop.getProductPriceBy(0));
    }

    @And("le prix du second ouvrage est correct {string}")
    public void lePrixDuSecondOuvrageEstCorrect(String arg0) {
        Assert.assertEquals(arg0, shop.getProductPriceBy(1));
    }

    @And("le prix du denier ouvrage est correct {string}")
    public void lePrixDuDenierOuvrageEstCorrect(String arg0) {
        Assert.assertEquals(arg0, shop.getProductPriceBy(7));
    }

    @And("je je select le filtre price High to Low")
    public void jeJeSelectLeFiltrePriceHighToLow() {
        shop.sortByPriceHighToLow();
    }

    @And("je saisis  mon mail {string} a SUBSCRIRE")
    public void jeSaisisMonMailASUBSCRIRE(String arg0) {
        shop.footer.enterAnEmailToSubscribe(arg0);
    }

    @And("je click sur le bouton SUBSCRIBE")
    public void jeClickSurLeBoutonSUBSCRIBE() {
        shop.footer.subscribeToATNewsletter();
    }

    @Then("un message erreur email inavlide est affiche {string}")
    public void unMessageErreurEmailInavlideEstAffiche(String arg0) {
        Assert.assertEquals(arg0, shop.footer.getInvalidEmailErrorMessage());
    }

    @Then("un message de confirmation de subscription est affiche {string}")
    public void unMessageDeConfirmationDeSubscriptionEstAffiche(String arg0) {
        Assert.assertEquals(arg0, shop.footer.getSubscriptionConfirmationMsg());
    }
}
