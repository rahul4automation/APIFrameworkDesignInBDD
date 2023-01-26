package SearchApiPlan.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import SearchApiPlan.actions.StepDefinition;
import SearchApiPlan.actions.BaseActionsClass;
import net.thucydides.core.annotations.Steps;

import static net.serenitybdd.rest.SerenityRest.*;
import static org.hamcrest.Matchers.*;

public class SearchProductSteps {

    @Steps
    public BaseActionsClass baseActionsClass;

    @Steps
    public StepDefinition searchProductActions;

    @When("^I hit the GET search API endpoint (.*)$")
    public void getSearchApiEndpoint(String product) {
        searchProductActions.searchTestProducts(product);
    }

    @When("I hit the get search test endpoint")
    public void getSearchApiEndpoint() {
        searchProductActions.searchTest();
    }

    @Then("I verify the search results of product should be displayed")
    public void searchResultDisplayed() {
        baseActionsClass.responseCodeIs(200);
    }

    @Then("I verify the product list should not be empty in Search results")
    public void productShouldDisplayedInSearchResult(){
        baseActionsClass.responseShouldNotBeEmptyList();
    }

    @Then("^I verify the product (.*) should be in Search results$")
    public void productShouldBeInSearchResult(String product) {
        searchProductActions.verityProductInResponseResult(product);
    }

    @Then("I verify not found error should be displayed in search results")
    public void searchResultItemNotDisplayed() {
        then().statusCode(404).body("detail.error", is(true));
    }

    @Then("I verify unauthorized error should be displayed in search result")
    public void unauthorizedError() {
        then().statusCode(401).body("detail", is("Not authenticated"));
    }

    @Then("I verify Success status Code should be displayed in search result")
    public void SuccessStatusCode() {
        baseActionsClass.responseCodeIs(200);
    }

    @And("the schema should match with the request specification{string}")
    public void validateSchema(String spec) {
        baseActionsClass.verifyResponseSchema(spec);
    }
}
