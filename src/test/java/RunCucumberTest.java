import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        // @-1-augmenter-quantity or @-2-diminuer-quantite or @-3-vide-basket

//        tags = {"@-1-augmenter-quantity"},
//        tags = {"@-3-vide-basket"},
        tags = {"@-1-augmenter-quantity or @-2-diminuer-quantite or @-3-vide-basket"},
//        tags = {"@-1-augmenter-quantity or @-3-vide-basket"},
        features = "src/test/resources/features",
        glue = "StepDefinitions",
        plugin = {"pretty", "html:target/cucumber-reports", "json:target/cucumber.json"}
)

public class RunCucumberTest {
//    @AfterClass
//    public static void importTestExecutionToJIRAXray() throws IOException, NoSuchAlgorithmException, KeyStoreException, InterruptedException, KeyManagementException {
//        ImportResultToXray apiConnector = new ImportResultToXray();
//        apiConnector.ImportToXray();
//    }
}
