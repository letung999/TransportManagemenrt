package transport.exception;

public class InvalidNameTransportException extends Exception {
    String name;

    public InvalidNameTransportException(String name) {
        this.name = name;
    }

    public InvalidNameTransportException(String message, String name) {
        super(message);
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
