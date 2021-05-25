package ProductCatalogue.Tests;

import ProductCatalogue.ProductApplication;
import io.cucumber.java.Before;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootContextLoader;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@CucumberContextConfiguration
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@ContextConfiguration(classes = ProductApplication.class, loader = SpringBootContextLoader.class)
public class cucumberConfig {
    @Before
    public void setUp() {
    }
}
