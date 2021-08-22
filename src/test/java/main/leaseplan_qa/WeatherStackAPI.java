package main.leaseplan_qa;

import net.serenitybdd.core.environment.EnvironmentSpecificConfiguration;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.util.EnvironmentVariables;

@DefaultUrl("")
public class WeatherStackAPI {

    EnvironmentVariables env;

    private String getBaseUrl(){
       return  EnvironmentSpecificConfiguration.from(env)
                .getProperty("host")+"/{type}";
    }

    private String getAPIKey(){
       return  EnvironmentSpecificConfiguration.from(env)
                .getProperty("api_key");
    }

    @Step("Get {0} weather by country {1}")
    public void queryWeather(String type, String country) {
        SerenityRest.given()
                .pathParam("type", type)
                .queryParam("access_key", getAPIKey())
                .queryParam("query", country)
                .get(getBaseUrl());
    }

    @Step("Get {0} weather with fake Auth by country {1}")
    public void queryWeatherWithFakeAuth(String type, String country) {
        SerenityRest.given()
                .pathParam("type", type)
                .queryParam("access_key", "INVALID_APIKey")
                .queryParam("query", country)
                .get(getBaseUrl());
    }

    @Step("Get {0} weather without Auth by country {1}")
    public void queryWeatherWithoutAuth(String type, String country) {
        SerenityRest.given()
                .pathParam("type", type)
                .queryParam("query", country)
                .get(getBaseUrl());
    }

    @Step("Get {0} weather without query")
    public void queryWeatherWithoutQuery(String type) {
        SerenityRest.given()
                .queryParam("access_key", getAPIKey())
                .pathParam("type", type)
                .get(getBaseUrl());
    }
    @Step("Get {0} weather using https")
    public void gueryHttpsEndpoint(String type, String country) {
        SerenityRest.given()
                .pathParam("type", type)
                .queryParam("access_key", getAPIKey())
                .queryParam("query", country)
                .get(getBaseUrl().replace("http","https"));
    }
}
