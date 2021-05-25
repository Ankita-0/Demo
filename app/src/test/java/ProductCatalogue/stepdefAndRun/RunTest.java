package ProductCatalogue.stepdefAndRun;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty", "json:target/cucumber.json"},
        features={"src/test/resources/featureFiles/ProductCart.feature"},
        extraGlue = "ProductCatalogue.Tests")
public class RunTest {
}
