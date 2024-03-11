package com.hexacta.tasks.services;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import static com.hexacta.factory.CreateUserDataFactory.RANDOM_ID;
import static com.hexacta.utils.enums.GenericEnums.*;
import static net.serenitybdd.rest.SerenityRest.given;

public class Get implements Task {

    private String resourceApi;

    private String dataType;

    public Get(String resourceApi) {
        this.resourceApi = resourceApi;
    }

    @Step("{0} consume get method")
    @Override
    public <T extends Actor> void performAs(T actor) {
        if (!"users".equals(resourceApi)) {
            given().with()
                    .queryParam(PAGE.getValue(), TWO_STRING.getValue()).
                    and().when().get(resourceApi.replaceAll(ALL.getValue(),""))
                    .then().extract().response();
        } else {

            given().
                    and().when().get(resourceApi + "/" + (USER_WITH_ID_INVALID.getValue().equals(dataType) ? MINUS_SYMBOL.getValue() : RANDOM_ID))
                    .then().extract().response();
        }
    }
    public static Get executeGetMethodWithThe(String resourceApi){
        return Tasks.instrumented(Get.class, resourceApi);
    }

    public Get with(String dataType){
        this.dataType = dataType;
        return this;
    }
}
