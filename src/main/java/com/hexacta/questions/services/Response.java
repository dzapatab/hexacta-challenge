package com.hexacta.questions.services;

import io.restassured.path.json.JsonPath;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Question;

public class Response {

    public static Question<Integer> getStatusCode(){
        return Question.about("Status code").answeredBy(actor -> SerenityRest.lastResponse().statusCode());
    }

    public static Question<String> getNameUser(){
        return Question.about("Get name user").answeredBy(actor -> JsonPath.from(SerenityRest.lastResponse().body().asString()).get("name").toString());
    }
    public static Question<String> getJob(){
        return Question.about("Get name job").answeredBy(actor -> JsonPath.from(SerenityRest.lastResponse().body().asString()).get("job").toString());
    }

    public static Question<String> getMessage(){
        return Question.about("Get message").answeredBy(actor -> JsonPath.from(SerenityRest.lastResponse().body().asString()).get("support.text").toString());
    }

    public static Question<String> getResponseBody(){
        return Question.about("Get response body").answeredBy(actor -> SerenityRest.lastResponse().body().asString());
    }
    public static Question<String> getHeader(){
        return Question.about("Get header").answeredBy(actor -> SerenityRest.lastResponse().getStatusLine());
    }

}
