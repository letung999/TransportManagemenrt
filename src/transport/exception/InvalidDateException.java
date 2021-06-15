package transport.exception;

public class InvalidDateException extends Exception {
    String date;

    public InvalidDateException(String date) {
        this.date = date;
    }

    public InvalidDateException(String message, String date) {
        super(message);
        this.date = date;
    }

    public String getDate() {
        return date;
    }

}
