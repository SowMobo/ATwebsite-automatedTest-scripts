package StepDefinitions;

import PagesObjectsModels.MyAccountPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class MyAccountStepdefs {
    WebDriver driver = Hook.driver;
    private MyAccountPage myAccount;
    public MyAccountStepdefs() {
        myAccount = new MyAccountPage(driver);
    }

    @And("je click sur le lien Logout")
    public void jeClickSurLeLienLogout() {
        myAccount.logout();
    }
    @And("je click sur le lien shop")
    public void jeClickSurLeLienShop() {
        myAccount.header.openShopPage();
    }

    @When("je click sur le lien Account Details")
    public void jeClickSurLeLienAccountDetails() {
        myAccount.openAccountDetailsPage();
    }

    @Then("le nom utilisateur est affichee sur la page My Account {string}")
    public void leNomUtilisateurEstAfficheeSurLaPageMyAccount(String arg0) {
        Assert.assertTrue(myAccount.getWelcomeMsg().contains(arg0));
    }

    @When("je click sur le logo BASKET depuis la page My Account")
    public void jeClickSurLeLogoBASKETDepuisLaPageMyAccount() {
        myAccount.header.openBasketByLogo();
    }
}
