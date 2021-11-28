import exceptions.AddEmptyProductException;
import exceptions.ProductAlreadyExistsInShopException;
import exceptions.ProductCannotBeModified;
import exceptions.ProductNotFoundException;

import java.util.Collections;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
//        Store store = new Store();
//
//        Product product = new Product(1, "A", 12d);
//        Product product2 = new Product(2, "B", 11d);
//        Product product3 = new Product(3, "C", 16d);
//
//        Product modifiedProduct = new Product(3, "D", 13d);
//
//        try {
//            store.addProduct(product);
//            store.addProduct(product2);
//            store.addProduct(product3);
//
//            store.getListProduct().sort(Comparator.comparing(Product::getPrice));
//            System.out.println("Sort by price: " + store.getListProduct());
//
//            store.deleteProduct(1);
//
//            Collections.reverse(store.getListProduct());
//            System.out.println("Sort by added time: " + store.getListProduct());
//
//            store.editProduct(modifiedProduct);
//
//            System.out.println(store.getListProduct());
//        } catch (AddEmptyProductException | ProductAlreadyExistsInShopException | ProductNotFoundException | ProductCannotBeModified e) {
//            e.printStackTrace();
//        }

        Menu menu = new Menu();
        menu.startMenu();
    }
}
