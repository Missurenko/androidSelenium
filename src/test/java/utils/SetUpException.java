package utils;

/**
 * Created by ${bohdan.missurenko} on 11/13/2018.
 */
public class SetUpException extends RuntimeException {

    SetUpException(String message, Throwable cause) {
        super(message, cause);
    }

    SetUpException(String message) {
        super(message);
    }
}
