package StepDefinitions;

import PagesObjectsModels.UserEmailAccountPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class UserEmailAccountStepdefs {
    WebDriver driver = Hook.driver;
    private UserEmailAccountPage userEmailAccountPage;
    
    public UserEmailAccountStepdefs() {
        userEmailAccountPage = new UserEmailAccountPage(driver);
    }
    @And("je ouvre le email envoye par le site AT correspondant au RESET PASSWORD")
    public void jeOuvreLeEmailEnvoyeParLeSiteATCorrespondantAuRESETPASSWORD() {
    }

    @And("je click sur le  lien RESET PASSWORD")
    public void jeClickSurLeLienRESETPASSWORD() {

    }

    @Then("je recois un email au bout de dix min {string}")
    public void jeRecoisUnEmailAuBoutDeDixMin(String arg0) {
        Assert.assertTrue(userEmailAccountPage.getNumberOfEmailReceived().contains(arg0));
    }


    @And("je ouvre ma boite de reception emails {string}")
    public void jeOuvreMaBoiteDeReceptionEmails(String arg0) {
        userEmailAccountPage.openMyEmailInBox(arg0);
    }
}
