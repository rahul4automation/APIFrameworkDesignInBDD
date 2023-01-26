package SearchApiPlan.actions;

import io.cucumber.java.en.Then;

import java.util.HashMap;
import java.util.List;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static net.serenitybdd.rest.SerenityRest.lastResponse;
import static net.serenitybdd.rest.SerenityRest.then;
import static org.assertj.core.api.Assertions.assertThat;


public class BaseActionsClass {



    @Then("Verify that API response is {int}")
    public void responseCodeIs(int responseCode) {
        then().statusCode(responseCode);
    }

    @Then("Verify that response list isn't an empty list")
    public void responseShouldNotBeEmptyList() {
        List<HashMap<String, Object>> res = lastResponse().getBody().jsonPath().getList("$");
        assertThat(res.size()).isNotZero();
    }

    @Then("Verify response schema with {string}")
    public void verifyResponseSchema(String schemaJson) {
        then().body(matchesJsonSchemaInClasspath("schema/" + schemaJson));
    }



}
