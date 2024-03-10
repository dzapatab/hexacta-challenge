package com.hexacta.tasks.web;

import com.hexacta.models.web.CreateUserRequest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import static com.hexacta.userinterfaces.AboutUs.*;
import static com.hexacta.utils.enums.GenericEnums.USER_WITH_EMAIL_INVALID_AND_WITHOUT_COMPANY;
import static com.hexacta.utils.enums.GenericEnums.VALID_USER;

public class SendDataLetsWorkTogether implements Task {

    private final CreateUserRequest createUserRequest;
    private String dataType;

    public SendDataLetsWorkTogether(CreateUserRequest createUserRequest) {
        this.createUserRequest = createUserRequest;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Enter.theValue(createUserRequest.getName()).into(FIRST_NAME),
        Enter.theValue(createUserRequest.getLastName()).into(LAST_NAME),
        Enter.theValue(createUserRequest.getEmail()).into(EMAIL),
        Enter.theValue(createUserRequest.getCompany()).into(COMPANY),
        Enter.theValue(createUserRequest.getYourMessage()).into(YOUR_MESSAGE));
        if(!VALID_USER.getValue().equals(dataType) && !USER_WITH_EMAIL_INVALID_AND_WITHOUT_COMPANY.getValue().equals(dataType)){
            actor.attemptsTo(Click.on(SEND_BUTTON));
        }

    }

    public static SendDataLetsWorkTogether inTheForm(CreateUserRequest createUserRequest) {
        return Tasks.instrumented(SendDataLetsWorkTogether.class, createUserRequest);
    }

    public SendDataLetsWorkTogether with(String dataType){
        this.dataType = dataType;
        return this;
    }
}