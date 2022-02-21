package by.vlad.task1.exception;

public class ReaderException extends Exception{
    public ReaderException() {
    }

    public ReaderException(String message) {
        super(message);
    }

    public ReaderException(String message, Exception e) {
        super(message, e);
    }

    public ReaderException(Exception e) {
        super(e);
    }
}
