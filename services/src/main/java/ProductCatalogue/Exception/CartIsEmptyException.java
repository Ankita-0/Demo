package ProductCatalogue.Exception;

public class CartIsEmptyException extends RuntimeException {
    public CartIsEmptyException(String msg){
        super(msg);
    }
}
