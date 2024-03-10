package com.hexacta.stepdefinitions;

import com.hexacta.drivers.Driver;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import org.junit.After;

public class Hook {
    @Before(order = 1)
    public void beforeScenario(Scenario scenario) {
        OnStage.setTheStage(new OnlineCast());
        OnStage.theActor("Diego");
        if(scenario.getSourceTagNames().contains("@services")){
            RestAssured.baseURI = "https://reqres.in";
            RestAssured.basePath = "/api/";
            RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
            RestAssured.requestSpecification = new RequestSpecBuilder()
                    .setContentType(ContentType.JSON)
                    .setRelaxedHTTPSValidation()
                    .build();
        }
    }

    @After()
    public void afterScenario(Scenario scenario) {
        if(!scenario.getSourceTagNames().contains("@services")) {
            Driver.getDriver().quit();
        }
    }
}
