package com.hexacta.factory;

import com.github.javafaker.Faker;
import com.hexacta.models.web.CreateUserRequest;
import org.apache.commons.lang3.StringUtils;
import static com.hexacta.models.web.CreateUserRequestBuilder.aUser;
import static com.hexacta.utils.enums.GenericEnums.*;

public class CreateUserDataFactory {

    private static final Faker FAKER = new Faker();
    public static final String RANDOM_ID = String.valueOf(FAKER.random().nextInt(1,10));
    public static final String NAME_USER = String.valueOf(FAKER.name().name());
    public static final String LAST_NAME_USER = String.valueOf(FAKER.name().lastName());
    public static final String EMAIL_USER = NAME_USER.concat(RANDOM_ID).concat(MAILINATOR_DOMAIN.getValue());
    public static final String COMPANY = String.valueOf(FAKER.company().name());
    public static final String MESSAGE = "Hello, I´m ".concat(NAME_USER + " " + LAST_NAME_USER).concat(" of de company ".concat(COMPANY).concat(" this is mi email: ").concat(EMAIL_USER));
    public static final String JOB = String.valueOf(FAKER.job().position());


    public static CreateUserRequest missingAllInformation(){
        return aUser()
                .withName(StringUtils.EMPTY)
                .withLastName(StringUtils.EMPTY)
                .withEmail(StringUtils.EMPTY)
                .withCompany(StringUtils.EMPTY)
                .build();
    }

    public static CreateUserRequest validUser(){
        return aUser()
                .withName(NAME_USER)
                .withLastName(LAST_NAME_USER)
                .withEmail(EMAIL_USER)
                .withCompany(COMPANY)
                .withMessage(MESSAGE)
                .build();
    }

    public static CreateUserRequest userWithoutCompany(){
        return aUser()
                .withName(NAME_USER)
                .withLastName(LAST_NAME_USER)
                .withEmail(EMAIL_USER)
                .withMessage(MESSAGE)
                .build();
    }

    public static CreateUserRequest userWithEmailInvalidAndWithoutCompany(){
        return aUser()
                .withName(NAME_USER)
                .withLastName(LAST_NAME_USER)
                .withEmail(RANDOM_ID)
                .withMessage(MESSAGE)
                .build();
    }

    public static CreateUserRequest userWithNameAndJobValid(){
        return aUser()
                .withName(NAME_USER)
                .withJob(JOB)
                .build();
    }

    public static CreateUserRequest userWithNameAndJobEmpty(){
        return aUser()
                .withName(StringUtils.EMPTY)
                .withJob(StringUtils.EMPTY)
                .build();
    }

    public static CreateUserRequest userWithNameValidAndJobEmpty(){
        return aUser()
                .withName(NAME_USER)
                .withJob(StringUtils.EMPTY)
                .build();
    }

    public static CreateUserRequest withoutJobParam(){
        return aUser()
                .withName(NAME_USER)
                .build();
    }
    public static CreateUserRequest createUserRequest(String dataType) {
        return switch (by(dataType)) {
            case MISSING_ALL_INFORMATION -> missingAllInformation();
            case VALID_USER -> validUser();
            case USER_WITHOUT_COMPANY -> userWithoutCompany();
            case USER_WITH_EMAIL_INVALID_AND_WITHOUT_COMPANY -> userWithEmailInvalidAndWithoutCompany();
            case USER_VALID -> userWithNameAndJobValid();
            case USER_WITHOUT_JOB -> userWithNameValidAndJobEmpty();
            case USER_WITH_JOB_INVALID -> userWithNameAndJobEmpty();
            case USER_WITHOUT_JOB_PARAM -> withoutJobParam();
            default -> throw new IllegalArgumentException("Invalid dataType: " + dataType);
        };
    }


}
