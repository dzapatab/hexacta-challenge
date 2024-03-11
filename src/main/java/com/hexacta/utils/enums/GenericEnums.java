package com.hexacta.utils.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import java.util.Arrays;
import java.util.EmptyStackException;

@Getter
@AllArgsConstructor
public enum GenericEnums {
    ALL("all "),
    IS_PRESENT("isPresent"),
    IS_NOT_PRESENT("isNotPresent"),
    INVALID_VALUE("Please complete this mandatory field."),
    INVALID_EMAIL_ADDRESS_MESSAGE("Please enter a valid email address"),
    MAILINATOR_DOMAIN("@mailinator.com"),
    MISSING_ALL_INFORMATION("missingAllInformation"),
    HEXACTA_URL("hexacta.url"),
    NULL_INFORMATION("nullInformation"),
    NOT_FOUND("Not Found"),
    PAGE("page"),
    VALID_USER("validUser"),
    SUCCESS("To keep ReqRes free, contributions towards server costs are appreciated!"),
    TWO_STRING("2"),
    USER_WITHOUT_COMPANY("userWithoutCompany"),
    USER_VALID("valid"),
    USER_WITHOUT_JOB("jobEmpty"),
    USER_WITH_JOB_INVALID("jobInvalid"),
    USER_WITHOUT_JOB_PARAM("withoutJobParam"),
    USER_WITH_ID_INVALID("idInvalid"),
    MINUS_SYMBOL("-"),

    USER_WITH_EMAIL_INVALID_AND_WITHOUT_COMPANY("userWithEmailInvalidAndWithoutCompany");

    private final String value;
    public static GenericEnums by(String constant) {
        return Arrays.stream(GenericEnums.values())
                .filter(section -> section.getValue().equalsIgnoreCase(constant))
                .findFirst().orElseThrow(EmptyStackException::new);
    }
}
