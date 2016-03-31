package ru.kpfu.itis.group11506.cafe;

public class UserInputException extends Exception {

    public UserInputException(String message) {
        super(message);
    }

    public UserInputException(Exception exception) {
        super(exception);
    }

    public UserInputException(String message, Exception cause) {
        super(message, cause);
    }

}
