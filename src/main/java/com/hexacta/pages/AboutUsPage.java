package com.hexacta.pages;
import com.hexacta.models.web.CreateUserRequest;

import static com.hexacta.pages.BasePage.*;
import static com.hexacta.utils.enums.GenericEnums.USER_WITH_EMAIL_INVALID_AND_WITHOUT_COMPANY;
import static com.hexacta.utils.enums.GenericEnums.VALID_USER;

public class AboutUsPage {

    public static final String FIRST_NAME = "(//input[@name='firstname'])[1]";
    public static final String ICON_ERROR_FIRST_NAME = "(//input[@name='firstname'])[1]/following-sibling::span//img";
    public static final String MESSAGE_MANDATORY_FIRST_NAME = "(//div[contains(text(), 'Please complete this mandatory field.')])[1]";
    public static final String LAST_NAME = "(//input[@name='lastname'])[1]";
    public static final String ICON_ERROR_LAST_NAME = "(//input[@name='lastname'])[1]/following-sibling::span//img";
    public static final String MESSAGE_MANDATORY_LAST_NAME = "(//div[contains(text(), 'Please complete this mandatory field.')])[2]";
    public static final String EMAIL =  "(//input[@name='email'])[1]";
    public static final String ICON_ERROR_EMAIL = "(//input[@name='email'])[1]/following-sibling::span//img";
    public static final String MANDATORY_MESSAGE_EMPTY_OR_NULL_EMAIL =  "(//div[contains(text(), 'Please complete this mandatory field.')])[3]";
    public static final String MESSAGE_MANDATORY_EMAIL = "(//div[contains(text(), 'Please enter a valid email address')])[1]";
    public static final String COMPANY = "(//input[@name='company//name'])[1]";
    public static final String SEND_BUTTON = "//input[@value='Send']";
    public static final String YOUR_MESSAGE = "//textarea[@placeholder='YOUR MESSAGE']";

    public void enterFirstName(String value) {
        waitElement(FIRST_NAME);
        clearAndSendKeys(FIRST_NAME, value);
    }

    public void enterLastName(String value) {
        waitElement(LAST_NAME);
        clearAndSendKeys(LAST_NAME, value);
    }

    public void enterEmail(String value) {
        waitElement(EMAIL);
        clearAndSendKeys(EMAIL, value);
    }

    public void enterCompany(String value) {
        waitElement(COMPANY);
        clearAndSendKeys(COMPANY, (value != null) ? value : "");
    }

    public void enterYourMessage(String value) {
        waitElement(YOUR_MESSAGE);
        clearAndSendKeys(YOUR_MESSAGE, (value != null) ? value : "");
    }

    public void clickSendButton() {
        waitElementAndClick(SEND_BUTTON);
    }

    public void sendDataLetsWorkTogether(CreateUserRequest createUserRequest, String dataType) {
        enterFirstName(createUserRequest.getName());
        enterLastName(createUserRequest.getLastName());
        enterEmail(createUserRequest.getEmail());
        enterCompany(createUserRequest.getCompany());
        enterYourMessage(createUserRequest.getYourMessage());
        if (!VALID_USER.getValue().equals(dataType) && !USER_WITH_EMAIL_INVALID_AND_WITHOUT_COMPANY.getValue().equals(dataType)) {
            clickSendButton();
        }
    }

}