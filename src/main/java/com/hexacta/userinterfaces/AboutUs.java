package com.hexacta.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class AboutUs {

    public static final Target FIRST_NAME = Target.the("about us FIRST NAME")
            .locatedBy("(//input[@name='firstname'])[1]");
    public static final Target ICON_ERROR_FIRST_NAME = Target.the("about us ICON ERROR FIRST NAME")
            .locatedBy("(//input[@name='firstname'])[1]/following-sibling::span//img");
    public static final Target MESSAGE_MANDATORY_FIRST_NAME = Target.the("about us MESSAGE MANDATORY FIRST NAME")
            .locatedBy("(//div[contains(text(), 'Please complete this mandatory field.')])[1]");
    public static final Target LAST_NAME = Target.the("about us LAST NAME")
            .locatedBy("(//input[@name='lastname'])[1]");
    public static final Target ICON_ERROR_LAST_NAME = Target.the("about us ICON ERROR LAST NAME")
            .locatedBy("(//input[@name='lastname'])[1]/following-sibling::span//img");
    public static final Target MESSAGE_MANDATORY_LAST_NAME = Target.the("about us MESSAGE MANDATORY LAST NAME")
            .locatedBy("(//div[contains(text(), 'Please complete this mandatory field.')])[2]");
    public static final Target EMAIL = Target.the("about us EMAIL")
            .locatedBy("(//input[@name='email'])[1]");
    public static final Target ICON_ERROR_EMAIL = Target.the("about us ICON ERROR EMAIL")
            .locatedBy("(//input[@name='email'])[1]/following-sibling::span//img");
    public static final Target MANDATORY_MESSAGE_EMPTY_OR_NULL_EMAIL = Target.the("about us MESSAGE MANDATORY EMAIL")
            .locatedBy("(//div[contains(text(), 'Please complete this mandatory field.')])[3]");
    public static final Target MESSAGE_MANDATORY_EMAIL = Target.the("about us MESSAGE MANDATORY EMAIL")
            .locatedBy("(//div[contains(text(), 'Please enter a valid email address')])[1]");
    public static final Target COMPANY = Target.the("about us COMPANY")
           .locatedBy("(//input[@name='company//name'])[1]");
    public static final Target SEND_BUTTON = Target.the("about us SEND BUTTON")
            .locatedBy("//input[@value='Send']");
    public static final Target YOUR_MESSAGE = Target.the("about us YOUR MESSAGE")
            .locatedBy("//textarea[@placeholder='YOUR MESSAGE']");

}
