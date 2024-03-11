package com.hexacta.tests;

import static com.hexacta.pages.AboutUsPage.*;
import static com.hexacta.pages.BasePage.*;

public class ValidateInTheFormPage {

    public static Boolean ifErrorAllIconsArePresentPage(){
            boolean iconErrorFirstName = askForThe(ICON_ERROR_FIRST_NAME);
            boolean iconErrorLastName = askForThe(ICON_ERROR_LAST_NAME);
            boolean iconErrorEmail = askForThe(ICON_ERROR_EMAIL);
            if(iconErrorFirstName && iconErrorLastName & iconErrorEmail) {
                waitElementAndClick(ICON_ERROR_FIRST_NAME);
                        waitElementAndClick(ICON_ERROR_LAST_NAME);
                        waitElementAndClick(ICON_ERROR_EMAIL) ;
                        waitElement(MESSAGE_MANDATORY_FIRST_NAME);
                        waitElement(MESSAGE_MANDATORY_LAST_NAME);
                        waitElement(MANDATORY_MESSAGE_EMPTY_OR_NULL_EMAIL);
                return true;
            }
            return false;
    }

    public static Boolean ifErrorIconsFirstNameIsPresentPage(){
            if(askForThe(ICON_ERROR_FIRST_NAME)) {
                waitElementAndClick(ICON_ERROR_FIRST_NAME);
                        waitElement(MESSAGE_MANDATORY_FIRST_NAME);
                return true;
            }
            return false;
    }


    public static Boolean ifErrorIconsLastNameIsPresentPage(){
            if(askForThe(ICON_ERROR_LAST_NAME)) {
                waitElementAndClick(ICON_ERROR_LAST_NAME);
                waitElement(MESSAGE_MANDATORY_LAST_NAME);
                return true;
            }
            return false;
    }


    public static Boolean ifErrorIconsEmailIsPresentPage(){
            if( askForThe(ICON_ERROR_EMAIL)) {
                waitElementAndClick(ICON_ERROR_EMAIL);
                        waitElement(MESSAGE_MANDATORY_EMAIL);
                return true;
            }
            return false;
    }
}
