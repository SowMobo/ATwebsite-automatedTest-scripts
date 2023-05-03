package StepDefinitions;

import PagesObjectsModels.AccountDetailsPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class AccountDetailsStepdefs {
    WebDriver driver = Hook.driver;
    AccountDetailsPage accountDetailsPage;
    public AccountDetailsStepdefs(){
        accountDetailsPage = new AccountDetailsPage(driver);
    }

    @And("je saisis mon de passe passe actuel {string}")
    public void jeSaisisMonDePassePasseActuel(String arg0) {
        accountDetailsPage.enterCurrentPassword(arg0);
    }

    @And("je saisis mon nouveau mot de passe {string}")
    public void jeSaisisMonNouveauMotDePasse(String arg0) {
        accountDetailsPage.enterNewPassword(arg0);
    }

    @And("je confirme mon nouveau mot de passe {string}")
    public void jeConfirmeMonNouveauMotDePasse(String arg0) {
        accountDetailsPage.confirmNewPassword(arg0);
    }

    @Then("une indication sur la qualite de password est affichee")
    public void uneIndicationSurLaQualiteDePasswordEstAffichee() {
        Assert.assertTrue(accountDetailsPage.isPasswordStrengthMsgDisplayed());
    }

    @And("une indication sur le format du mot de passe est affichee")
    public void uneIndicationSurLeFormatDuMotDePasseEstAffichee() {
        Assert.assertTrue(accountDetailsPage.isPasswordHintDisplayed());
    }

    @And("le button REGISTER est grise")
    public void leButtonREGISTEREstGrise() {
        Assert.assertFalse(accountDetailsPage.isSaveChangeButtonDisabled());
    }
}
