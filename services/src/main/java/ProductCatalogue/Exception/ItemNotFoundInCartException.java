package ProductCatalogue.Exception;

public class ItemNotFoundInCartException extends RuntimeException{

    public ItemNotFoundInCartException(String msg){
        super(msg);
    }
}
