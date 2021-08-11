package testcases;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Test;
import org.junit.runner.RunWith;
import steps.WeatherStackApiSteps;

@RunWith(SerenityRunner.class)
public class GetCityWeather extends Basetest{

    @Steps
    WeatherStackApiSteps api;

    @Title("Getting the weather request for Veldhoven")
    @Test
    public void veldhovenCityWeatherRequest() {

        api.sendGetRequestForCityForWeatherUpdate("Veldhoven");
        api.validateStatusCodeToBe(200);
        api.verifyResponseBody("request.language", "en");
        api.verifyResponseBody("location.country", "Netherlands");
    }
}
