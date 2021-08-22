package main.leaseplan_qa;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.equalToIgnoringCase;

public class WeatherStackStepDefinitions {

    @Steps
    WeatherStackAPI weatherStackAPI;

    @When("I search for {} weather in {}")
    public void searchForWeatherIn(String type, String country) {
        weatherStackAPI.queryWeather(type, country);
    }

    @When("I search https endpoint for {} weather in {}")
    public void searchHttpsForWeatherIn(String type, String country) {
        weatherStackAPI.gueryHttpsEndpoint(type, country);
    }

    @When("I search without AccessKey for {} weather in {}")
    public void searchWithoutAccessKeyForWeatherIn(String type, String country) {
        weatherStackAPI.queryWeatherWithoutAuth(type, country);
    }

    @When("I search without country for {} weather")
    public void searchWithoutQueryForWeatherIn(String type) {
        weatherStackAPI.queryWeatherWithoutQuery(type);
    }

    @When("I search with invalid AccessKey for {} weather in {}")
    public void searchWithInvalidAccessKeyForWeatherIn(String type, String country) {
        weatherStackAPI.queryWeatherWithFakeAuth(type, country);
    }

    @Then("the response code should be {int}")
    public void theResponseCodeShouldBe(Integer code) {
        restAssuredThat(response -> response.statusCode(code));
    }

    @Then("the response should be of {}")
    public void theResponseShouldBelongTo(String country) {
        restAssuredThat(response -> response.body(WeatherResponse.COUNTRY, equalToIgnoringCase(country)));
    }

    @Then("the response body should contain error {int}")
    public void theResponseShouldContainError(Integer errorCode) {
        restAssuredThat(response -> response.body(WeatherResponse.ERROR_CODE, equalTo(errorCode)));
    }

    @Then("the response body should contain error string {}")
    public void theResponseShouldContainErrorString(String errorCode) {
        restAssuredThat(response -> response.body(WeatherResponse.ERROR_CODE_STRING, equalToIgnoringCase(errorCode)));
    }

}
