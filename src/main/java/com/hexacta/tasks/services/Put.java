package com.hexacta.tasks.services;

import com.google.gson.Gson;
import com.hexacta.models.web.CreateUserRequest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import static com.hexacta.factory.CreateUserDataFactory.RANDOM_ID;
import static net.serenitybdd.rest.SerenityRest.given;

public class Put implements Task {

    private final String resourceApi;
    private CreateUserRequest dataType;
    public Put(String resourceApi) {
        this.resourceApi = resourceApi;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        given()
                .body(new Gson().toJson(dataType))
                .and()
                .when().put(resourceApi+"/"+RANDOM_ID)
                .then().extract().response();
    }

    public static Put modifyUserWithThe(String resourceApi){
        return Tasks.instrumented(Put.class, resourceApi);
    }

    public Put with(CreateUserRequest dataType){
        this.dataType = dataType;
        return this;
    }
}
