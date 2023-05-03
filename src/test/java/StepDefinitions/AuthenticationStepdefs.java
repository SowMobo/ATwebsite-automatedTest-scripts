package StepDefinitions;

import PagesObjectsModels.AuthenticationPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class AuthenticationStepdefs {
    WebDriver driver = Hook.driver;
    private AuthenticationPage login;

    public AuthenticationStepdefs() {
        login = new AuthenticationPage(driver);
    }

    @And("je saisis mon login  {string}")
    public void jeSaisisMonLogin(String arg0) {
        login.enterUsernameOrEmail(arg0);
    }

    @And("je saisis mon mot de passe {string}")
    public void jeSaisisMonMotDePasse(String arg0) {
        login.enterPassword(arg0);
    }

    @And("je click sur le button LOGIN")
    public void jeClickSurLeButtonLOGIN() {
        login.openMyAccount();
    }


    @And("je coche option Remember Me")
    public void jeCocheOptionRememberMe() {
        login.rememberMe();
    }



    @Then("un message erreur est affiche sur la page Authentification {string}")
    public void unMessageErreurEstAfficheSurLaPageAuthentification(String arg0) {
        Assert.assertEquals(arg0, login.getLoginErrorMessage());
    }

    @Given("je me connecte avec {string} et {string}")
    public void jeMeConnecteAvecEt(String arg0, String arg1) {
        login.loginWith(arg0, arg1);
    }

    @Then("le titre Login est affichee sur la page authentification")
    public void leTitreLoginEstAfficheeSurLaPageAuthentification() {
       Assert.assertTrue(login.isLoginTitleDisplayed());
    }

    @And("je click sur le lien Lost your password")
    public void jeClickSurLeLienLostYourPassword() {
        login.openLostPasswordPasswordPage();
    }

}
