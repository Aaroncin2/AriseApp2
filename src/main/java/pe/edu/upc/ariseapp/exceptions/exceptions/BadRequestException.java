package pe.edu.upc.ariseapp.exceptions.exceptions;

public class BadRequestException  extends RuntimeException {
    public BadRequestException(String message) {
        super(message);
    }
}