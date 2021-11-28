import exceptions.AddEmptyProductException;
import exceptions.ProductAlreadyExistsInShopException;
import exceptions.ProductCannotBeModified;
import exceptions.ProductNotFoundException;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Menu {
    private HashMap<String, String> menu = new HashMap<>();
    private HashMap<String, String> sortMenu = new HashMap<>();
    private Store store = new Store();

    public void startMenu() {
        createMenu();
        createSortMenu();
        while (true) {
            showMenu(menu);
            try {
                performAction();
            } catch (ProductAlreadyExistsInShopException | AddEmptyProductException |
                    ProductNotFoundException | ProductCannotBeModified e) {
                e.printStackTrace();
            }
        }
    }

    private void createMenu() {
        menu.put("0", "Show all product");
        menu.put("1", "Add product");
        menu.put("2", "Delete product");
        menu.put("3", "Edit product");
        menu.put("4", "Exit");
    }

    private void createSortMenu() {
        sortMenu.put("0", "Sort products by price ascending");
        sortMenu.put("1", "Sort products by price descending");
        sortMenu.put("2", "Sort products by added time");
    }

    private void showMenu(Map<String, String> menu) {
        menu.forEach((key, value) -> System.out.println(key + " - " + value));
    }

    private void performAction() throws ProductAlreadyExistsInShopException, AddEmptyProductException,
            ProductNotFoundException, ProductCannotBeModified {
        int actionNumber = getActionNumber(menu);
        if (actionNumber == 0) {
            showMenu(sortMenu);
            System.out.println(getSortedProductList(getActionNumber(sortMenu)));
        } else if (actionNumber == 1) {
            store.addProduct(getProduct());
        } else if (actionNumber == 2) {
            store.deleteProduct(getConsoleProductId(new Scanner(System.in)));
        } else if (actionNumber == 3) {
            store.editProduct(getProduct());
        } else if (actionNumber == 4) {
            System.exit(0);
        }
    }

    private int getActionNumber(Map<String,String> menu) {
        Scanner scanner = new Scanner(System.in);

        int actionNumber;
        while (true) {
            System.out.print("Select the menu item: ");
            if (scanner.hasNextInt()) {
                actionNumber = scanner.nextInt();
                if (actionNumber < 0 || actionNumber > menu.size() - 1) {
                    System.out.println("Please enter a number from 0 to " + (menu.size() - 1));
                } else {
                    return actionNumber;
                }
            } else {
                System.out.println("You are entering letters. " + "Please enter a number from 0 to " +
                        (menu.size() - 1));
                scanner.next();
            }
        }
    }

    private List<Product> getSortedProductList(int sortMenuItem) {
        if (store.getListProduct() != null) {
            Stream<Product> productStream = store.getListProduct().stream();
            return switch (sortMenuItem) {
                case 0 -> productStream.sorted(Comparator.comparing(Product::getPrice))
                        .collect(Collectors.toList());
                case 1 -> productStream.sorted(Comparator.comparing(Product::getPrice, Comparator.reverseOrder()))
                        .collect(Collectors.toList());
                case 2 -> IntStream.range(0, store.getListProduct().size())
                        .map(i -> store.getListProduct().size() - i - 1)
                        .mapToObj(store.getListProduct()::get).collect(Collectors.toList());
                default -> throw new IllegalStateException("Unexpected value: " + sortMenuItem);
            };
        }
        return Collections.emptyList();
    }

    private Product getProduct() {
        Scanner scanner = new Scanner(System.in);

        Product product = new Product();
        product.setId(getConsoleProductId(scanner));
        product.setName(getConsoleProductName(scanner).trim());
        product.setPrice(getConsoleProductPrice(scanner));
        return product;
    }

    private int getConsoleProductId(Scanner scanner) {
        int productId;
        while (true) {
            System.out.print("Enter product ID: ");
            if (scanner.hasNextInt()) {
                productId = scanner.nextInt();
                if (productId < 0) {
                    System.out.println("Enter a positive integer");
                } else {
                    return productId;
                }
            } else {
                System.out.println("Incorrect product ID");
                scanner.next();
            }
        }
    }

    private String getConsoleProductName(Scanner scanner) {
        String productName;
        while (true) {
            System.out.print("Enter product name: ");
            productName = scanner.next();
            if (!productName.isBlank()) {
                return productName;
            } else {
                scanner.next();
            }
            System.out.println("Incorrect product name.");
        }
    }

    private double getConsoleProductPrice(Scanner scanner) {
        double productPrice;
        while (true) {
            System.out.print("Enter product price: ");
            if (scanner.hasNextDouble()) {
                productPrice = scanner.nextDouble();
                if (productPrice < 0) {
                    System.out.println("Enter a positive number");
                } else {
                    return productPrice;
                }
            } else {
                System.out.println("Incorrect product price");
                scanner.next();
            }
        }
    }
}
