package ProductCatalogue.stepdefAndRun;

import ProductCatalogue.ModelAndRepository.Manufacturer;
import ProductCatalogue.ModelAndRepository.Product;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MyStepdefs {

    @LocalServerPort
    private int port;

    Product[] batch;
    Manufacturer product;
    String n;
    private final RestTemplate restTemplate = new RestTemplate();
    ResponseEntity<Product> prod;
    ResponseEntity<String> res;
    ResponseEntity<Product[]> b;
    String uri;

    @Given("the {int} and {int} is given")
    public void theBatch_idAndIdIsGiven(int batch_id, int id) {
        uri = "http://localhost:" + port + "/batches/" + String.valueOf(batch_id) + "/products/" + String.valueOf(id);
        res = restTemplate.getForEntity(uri, String.class);
        System.out.println("in given");
    }

    @Then("the product with the given {int} and {int} will be displayed")
    public void theProductWithTheGivenBatch_idAndIdWillBeDisplayed(int batch_id, int id) {
        product = restTemplate.getForEntity(uri, Manufacturer.class).getBody();
    }

    @And("the status will be {int}")
    public void theStatusWillBe(int httpStatus) {
        assertEquals(httpStatus, res.getStatusCodeValue());
    }

    @When("the uri with endpoint {string} is used")
    public void theUriWithEndpointIsUsed(String endpoint) {
        uri = "http://localhost:" + port + endpoint;
    }

    @Then("all the batches will be displayed")
    public void allTheBatchesWillBeDisplayed() {
        b = restTemplate.getForEntity(uri, Product[].class);
        batch=b.getBody();
        assertTrue(b.hasBody());
    }

    @And("the status will then be {int}")
    public void theStatusWillThenBe(int status) {
        assertEquals(status, b.getStatusCodeValue());
    }
}