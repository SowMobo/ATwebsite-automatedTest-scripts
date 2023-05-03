package StepDefinitions;

import PagesObjectsModels.LostPasswordPage;
import PagesObjectsModels.ShopPage;
import cucumber.api.java.en.And;
import org.openqa.selenium.WebDriver;

public class LostPasswordStepdefs {
    WebDriver driver = Hook.driver;
    private LostPasswordPage lostPasswordPage;

    public LostPasswordStepdefs() {
        lostPasswordPage = new LostPasswordPage(driver);
    }

    @And("je click sur le button RESET PASSWORD")
    public void jeClickSurLeButtonRESETPASSWORD() {
        lostPasswordPage.sendResetPasswordLink();
    }

    @And("je saisis mon login  sur la page lost password {string}")
    public void jeSaisisMonLoginSurLaPageLostPassword(String arg0) {
        lostPasswordPage.enterEmail(arg0);
    }

    //    @And("je ouvre mon compte email correspondant au login {string}")
//    public void jeOuvreMonCompteEmailCorrespondantAuLogin(String arg0) {
//        lostPasswordPage.openUserAccountPage(arg0);
//    }
    @And("je ouvre la page accueil de ma boite email {string}")
    public void jeOuvreLaPageAccueilDeMaBoiteEmail(String arg0) {
        lostPasswordPage.openUserAccountHomePage(arg0);
    }
}
