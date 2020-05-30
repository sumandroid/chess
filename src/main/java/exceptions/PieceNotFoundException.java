package exceptions;

public class PieceNotFoundException extends RuntimeException {

    public PieceNotFoundException(String message){
        super(message);
    }
}
