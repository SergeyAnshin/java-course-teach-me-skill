import java.time.LocalDateTime;
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


    public void addProduct(Product product) {
        if (listProduct == null) {
            listProduct = new ArrayList<>();
        }

        if (product == null) {
            System.out.println("You try to add a null value to the store.");
        } else if (listProduct.contains(product)) {
            System.out.println("Product with id " + product.getId() + " already exists");
        }

        listProduct.add(product);
    }

    public void deleteProduct(int productId) {
        if (!listProduct.removeIf(product -> product.getId() == productId)) {
            System.out.println("There is no product with id = " + productId);
        }
    }

    public void editProduct(Product product) {
        int productIndexToChange;
        if (product != null && (productIndexToChange = listProduct.indexOf(product)) != -1) {
            Product productToChange = listProduct.get(productIndexToChange);
            productToChange.setName(product.getName());
            productToChange.setPrice(product.getPrice());
            productToChange.setUpdateDate(LocalDateTime.now());
        } else {
            System.out.println("Product to modification does not exist");
        }
    }
}
