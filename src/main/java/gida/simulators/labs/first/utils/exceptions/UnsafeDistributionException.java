package gida.simulators.labs.first.utils.exceptions;

public class UnsafeDistributionException extends RuntimeException {

    public UnsafeDistributionException(String message) {
        super(message);
    }

    public UnsafeDistributionException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
