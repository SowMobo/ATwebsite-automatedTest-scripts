import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;

@RunWith(Cucumber.class)
@CucumberOptions(
        tags = {"@authentification"},
        features = "src/test/resources/features",
        glue = "StepDefinitions",
        plugin = {"pretty", "html:target/cucumber-reports", "json:target/cucumber.json"}
)

public class TestsRunner {
//    @AfterClass
//    public static void importTestExecutionToJIRAXray() throws IOException, NoSuchAlgorithmException, KeyStoreException, InterruptedException, KeyManagementException {
//        ImportResultToXray apiConnector = new ImportResultToXray();
//        apiConnector.ImportToXray();
//    }
}
