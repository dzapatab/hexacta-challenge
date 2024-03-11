package com.hexacta.tasks.web;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Hit;
import org.openqa.selenium.Keys;

import static com.hexacta.interactions.Wait.waitTheElement;
import static com.hexacta.userinterfaces.AboutUs.MESSAGE_MANDATORY_FIRST_NAME;
import static com.hexacta.userinterfaces.Home.*;
import static com.hexacta.userinterfaces.Home.CLOSE_IMAGE;
import static com.hexacta.utils.enums.GenericEnums.IS_PRESENT;

public class Search implements Task {

    private String value;

    public Search(String value) {
        this.value = value;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                waitTheElement(CLOSE_IMAGE).expectedState(IS_PRESENT.getValue()),
                Click.on(CLOSE_IMAGE),
                waitTheElement(SEARCH_ICON).expectedState(IS_PRESENT.getValue()),
                Click.on(SEARCH_ICON),
                waitTheElement(INPUT_SEARCH).expectedState(IS_PRESENT.getValue()),
                Enter.theValue(value).into(INPUT_SEARCH),
                Hit.the(Keys.ENTER).into(INPUT_SEARCH));
    }

    public static Search anOption(String value) {
        return Tasks.instrumented(Search.class, value);
    }

}
