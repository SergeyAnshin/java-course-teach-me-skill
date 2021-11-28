package exceptions;

public class ProductAlreadyExistsInShopException extends Exception {

    public ProductAlreadyExistsInShopException() {
        super();
    }

    public ProductAlreadyExistsInShopException(String message) {
        super(message);
    }
}
