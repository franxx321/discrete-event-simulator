package gida.simulators.labs.first.utils.exceptions;

public class BadDistributionException extends RuntimeException {

    public BadDistributionException(String message) {
        super(message);
    }

    public BadDistributionException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
