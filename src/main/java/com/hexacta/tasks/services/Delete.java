package com.hexacta.tasks.services;
import static com.hexacta.factory.CreateUserDataFactory.RANDOM_ID;
import static net.serenitybdd.rest.SerenityRest.given;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

public class Delete implements Task {

    private final String resourceApi;

    public Delete(String resourceApi) {
        this.resourceApi = resourceApi;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        given().
                and().when().delete(resourceApi+"/"+ RANDOM_ID )
                .then().extract().response();
    }

    public static Delete deleteUser(String resourceApi){
        return Tasks.instrumented(Delete.class, resourceApi);
    }
}
