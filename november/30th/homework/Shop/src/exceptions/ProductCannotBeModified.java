package exceptions;

public class ProductCannotBeModified extends Exception {

    public ProductCannotBeModified() {
        super();
    }

    public ProductCannotBeModified(String message) {
        super(message);
    }
}
