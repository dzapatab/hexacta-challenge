package com.hexacta.exceptions;

public class GeneralMessage extends AssertionError {
    public static final String ERROR_NO_MESSAGE_FOUND = "Error , The messages are not equals";
    public static final String THE_CODES_DO_NOT_MATCH = "The last response are not equal to the status code expected";
    public static final String THE_MESSAGE_DO_NOT_MATCH = "The last response are not equal to the message expected";

    public GeneralMessage(String message, Throwable cause) {
        super(message, cause);
    }
}