package com.hexacta.tasks.web;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import static com.hexacta.interactions.Wait.waitTheElement;
import static com.hexacta.tasks.web.HeaderOption.selectHeaderOption;
import static com.hexacta.userinterfaces.Home.CLOSE_IMAGE;
import static com.hexacta.utils.enums.GenericEnums.IS_PRESENT;
import static com.hexacta.utils.enums.OptionsHeader.ABOUT_US;
import static com.hexacta.utils.enums.OptionsHeader.COMPANY;

public class InAboutUs implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                waitTheElement(CLOSE_IMAGE).expectedState(IS_PRESENT.getValue()),
        Click.on(CLOSE_IMAGE),
        selectHeaderOption(COMPANY.getValue()).andSelectOptionInTheHeader(ABOUT_US.getValue()));
    }

    public static InAboutUs selectAnOption() {
        return Tasks.instrumented(InAboutUs.class);
    }
}