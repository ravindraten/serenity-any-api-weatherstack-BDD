package testcases;

import io.restassured.RestAssured;
import org.junit.BeforeClass;

public class Basetest {

    @BeforeClass
    public static void init() {

        RestAssured.baseURI = "http://api.weatherstack.com";
        RestAssured.basePath = "";

    }
}
