package StepDefinitions;

import PagesObjectsModels.HomePage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;

public class HomeStepdefs {
    WebDriver driver = Hook.driver;
    private HomePage home;
    public HomeStepdefs() {
        home = new HomePage(driver);
    }

    @Given("je ouvre le site AT")
    public void jeOuvreLeSiteAT() {
        home.openSUT();
    }

    @When("je click sur le lien My Account")
    public void jeClickSurLeLienMyAccount() {
        home.openAuthenticationPage();
        home.closeAd();
    }


    @And("je click sur le logo AT")
    public void jeClickSurLeLogoAT() {
        home.openHomePage();
    }

    @Then("le titre new arrivals est affiche")
    public void leTitreNewArrivalsEstAffiche() {
        home.isNewArrivalsDisplayed();
    }

}