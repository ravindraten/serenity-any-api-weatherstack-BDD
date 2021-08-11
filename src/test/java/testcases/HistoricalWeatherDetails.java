package testcases;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Test;
import org.junit.runner.RunWith;
import steps.WeatherStackApiSteps;

@RunWith(SerenityRunner.class)
public class HistoricalWeatherDetails extends Basetest{

    @Steps
    WeatherStackApiSteps api;

    @Title("Getting the historical weather data for Veldhoven")
    @Test
    public void historicalDataRequestForCity() {
        api.sendGetRequestForCityForHistoricalData("Veldhoven", "2021-07-10", "2021-07-01");
        api.validateStatusCodeToBe(200);
        api.verifyResponseBody("error.info", "Your current subscription plan does not support historical weather data. Please upgrade your account to use this feature.");
    }
}
