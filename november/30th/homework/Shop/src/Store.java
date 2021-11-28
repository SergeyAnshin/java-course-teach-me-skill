import exceptions.AddEmptyProductException;
import exceptions.ProductAlreadyExistsInShopException;
import exceptions.ProductCannotBeModified;
import exceptions.ProductNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class Store {
    private List<Product> listProduct;

    public Store() {
    }

    public Store(List<Product> listProduct) {
        this.listProduct = listProduct;
    }

    public List<Product> getListProduct() {
        return listProduct;
    }


    public void addProduct(Product product) throws AddEmptyProductException, ProductAlreadyExistsInShopException {
        if (listProduct == null) {
            listProduct = new ArrayList<>();
        }

        if (product == null) {
            throw new AddEmptyProductException("You try to add a null value to the store.");
        } else if (listProduct.contains(product)) {
            throw new ProductAlreadyExistsInShopException("Product with id " + product.getId() + " already exists");
        }

        listProduct.add(product);
    }

    public void deleteProduct(int productId) throws ProductNotFoundException {
        if (!listProduct.removeIf(product -> product.getId() == productId)) {
            throw new ProductNotFoundException("There is no product with id = " + productId);
        }
    }

    public void editProduct(Product product) throws ProductCannotBeModified {
        if (product != null && listProduct.removeIf(product1 -> product1.equals(product))) {
            listProduct.add(product);
        } else {
            throw new ProductCannotBeModified("Product to modification does not exist");
        }
    }
}
