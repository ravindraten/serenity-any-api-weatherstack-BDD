package testcases;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Test;
import org.junit.runner.RunWith;
import steps.WeatherStackApiSteps;
import java.util.Date;
import java.text.*;

@RunWith(SerenityRunner.class)
public class ForecastWeatherDetails extends Basetest{

    @Steps
    WeatherStackApiSteps api;
    
    @Title("Getting the forecast weather data for Veldhoven")
    @Test
    public void forecastDataRequestForCity() {
        api.sendGetRequestForCityForForecastData("Veldhoven", "1", "1");
        api.validateStatusCodeToBe(200);
        /* api.verifyResponseBody("request.language", "en");
        api.verifyResponseBody("location.country", "Netherlands");
        String pattern = "yyyy-MM-dd";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String date = simpleDateFormat.format(new Date());
        api.verifyResponseBody("forecast", date); */
        api.verifyResponseBody("error.info", "Your current subscription plan does not support weather forecast data. Please upgrade your account to use this feature.");
    }
}
