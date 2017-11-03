package dea.luclinders.spotitube.businesslogic;

public class InvalidTokenException extends Exception {

    public InvalidTokenException(String message) {
        super(message);
    }

    public InvalidTokenException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
