package com.hexacta.tasks.web;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.MoveMouse;

import static com.hexacta.interactions.Wait.waitTheElement;
import static com.hexacta.userinterfaces.HomePage.HEADER_OPTIONS;
import static com.hexacta.userinterfaces.HomePage.SELECT_OPTIONS_IN_THE_HEADER;
import static com.hexacta.utils.enums.GenericEnums.IS_PRESENT;

public class HeaderOption implements Task {
    private String headerOption;

    private String optionInTheHeader;

    public HeaderOption(String headerOption) {
        this.headerOption = headerOption;
    }

    public HeaderOption andSelectOptionInTheHeader(String optionInTheHeader){
        this.optionInTheHeader = optionInTheHeader;
        return this;
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(waitTheElement(HEADER_OPTIONS.of(headerOption)).expectedState(IS_PRESENT.getValue()),
        MoveMouse.to(HEADER_OPTIONS.of(headerOption))
                .andThen(actions -> Click.on(HEADER_OPTIONS.of(headerOption))),
        waitTheElement(SELECT_OPTIONS_IN_THE_HEADER.of(optionInTheHeader)).expectedState(IS_PRESENT.getValue()),
        Click.on(SELECT_OPTIONS_IN_THE_HEADER.of(optionInTheHeader)));
    }

    public static HeaderOption selectHeaderOption(String headerOption) {
        return Tasks.instrumented(HeaderOption.class, headerOption);
    }

}