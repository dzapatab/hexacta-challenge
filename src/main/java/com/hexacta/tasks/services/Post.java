package com.hexacta.tasks.services;

import com.google.gson.Gson;
import com.hexacta.models.web.CreateUserRequest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

import static net.serenitybdd.rest.SerenityRest.given;

public class Post implements Task {
    private String resourceApi;
    private CreateUserRequest dataType;

    public Post(String resourceApi) {
        this.resourceApi = resourceApi;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        given()
                .body(new Gson().toJson(dataType))
                .and().post(resourceApi)
                .then().extract().response();
    }


    public static Post createUserWithThe(String resourceApi){
        return Tasks.instrumented(Post.class, resourceApi);
    }

    public Post with(CreateUserRequest dataType){
        this.dataType = dataType;
        return this;
    }
}
