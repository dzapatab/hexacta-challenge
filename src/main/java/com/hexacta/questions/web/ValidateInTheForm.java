package com.hexacta.questions.web;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.actions.Click;
import static com.hexacta.interactions.Wait.checkElementState;
import static com.hexacta.interactions.Wait.waitTheElement;
import static com.hexacta.userinterfaces.AboutUs.*;

import static com.hexacta.utils.enums.GenericEnums.IS_PRESENT;

public class ValidateInTheForm {
    @Step("{0} validate if all errors icons are present")
    public static Question<Boolean> ifErrorAllIconsArePresent(){
        return actor -> {
            boolean iconErrorFirstName = checkElementState(ICON_ERROR_FIRST_NAME, IS_PRESENT.getValue());
            boolean iconErrorLastName = checkElementState(ICON_ERROR_LAST_NAME, IS_PRESENT.getValue());
            boolean iconErrorEmail = checkElementState(ICON_ERROR_EMAIL, IS_PRESENT.getValue());
            if(iconErrorFirstName && iconErrorLastName & iconErrorEmail) {
                actor.attemptsTo(Click.on(ICON_ERROR_FIRST_NAME),
                        Click.on(ICON_ERROR_LAST_NAME),
                        Click.on(ICON_ERROR_EMAIL) ,
                        waitTheElement(MESSAGE_MANDATORY_FIRST_NAME).expectedState(IS_PRESENT.getValue()),
                        waitTheElement(MESSAGE_MANDATORY_LAST_NAME).expectedState(IS_PRESENT.getValue()),
                        waitTheElement(MANDATORY_MESSAGE_EMPTY_OR_NULL_EMAIL).expectedState(IS_PRESENT.getValue())
                       );
                return true;
            }
            return false;
        };
    }

    @Step("{0} validate if error icon of first name is present")
    public static Question<Boolean> ifErrorIconsFirstNameIsPresent(){
        return actor -> {
            if( checkElementState(ICON_ERROR_FIRST_NAME, IS_PRESENT.getValue())) {
                actor.attemptsTo(Click.on(ICON_ERROR_FIRST_NAME),
                        waitTheElement(MESSAGE_MANDATORY_FIRST_NAME).expectedState(IS_PRESENT.getValue()));
                return true;
            }
            return false;
        };
    }

    @Step("{0} validate if error icon of last name is present")
    public static Question<Boolean> ifErrorIconsLastNameIsPresent(){
        return actor ->
        {
            if( checkElementState(ICON_ERROR_LAST_NAME, IS_PRESENT.getValue())) {
                actor.attemptsTo(Click.on(ICON_ERROR_LAST_NAME),
                        waitTheElement(MESSAGE_MANDATORY_LAST_NAME).expectedState(IS_PRESENT.getValue()));
                return true;
            }
            return false;
        };
    }

    @Step("{0} validate if error icon of email is present")
    public static Question<Boolean> ifErrorIconsEmailIsPresent(){
        return actor ->
        {
            if( checkElementState(ICON_ERROR_EMAIL, IS_PRESENT.getValue())) {
            actor.attemptsTo(Click.on(ICON_ERROR_EMAIL),
                    waitTheElement(MESSAGE_MANDATORY_EMAIL).expectedState(IS_PRESENT.getValue()));
            return true;
        }
            return false;
        };
    }
}
