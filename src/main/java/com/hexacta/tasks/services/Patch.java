package com.hexacta.tasks.services;

import com.google.gson.Gson;

import com.hexacta.models.web.CreateUserRequest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

import static com.hexacta.factory.CreateUserDataFactory.RANDOM_ID;
import static com.hexacta.factory.CreateUserDataFactory.userWithNameAndJobValid;
import static net.serenitybdd.rest.SerenityRest.given;

public class Patch implements Task {
    private final String resourceApi;

    public Patch(String resourceApi) {
        this.resourceApi = resourceApi;
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        CreateUserRequest userValid = userWithNameAndJobValid();

        String employeeJson = new Gson().toJson(userValid);

        given()
                .body(employeeJson)
                .and()
                .when().patch(resourceApi+"/"+RANDOM_ID)
                .then().extract().response();
    }

    public static Patch modifyAnUserWithThe(String resourceApi){
        return Tasks.instrumented(Patch.class, resourceApi);
    }
}
