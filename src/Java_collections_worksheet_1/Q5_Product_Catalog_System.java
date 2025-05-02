package Java_collections_worksheet_1;

import java.util.*;

class Product {
    int id;
    String name;
    double price;
    double rating;
    int stock;

    public Product(int id, String name, double price, double rating, int stock) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.rating = rating;
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", rating=" + rating +
                ", stock=" + stock +
                '}';
    }
}

class ProductComparator implements Comparator<Product> {
    @Override
    public int compare(Product p1, Product p2) {
        if (p2.rating != p1.rating) {
            return Double.compare(p2.rating, p1.rating);
        } else {
            return p1.name.compareTo(p2.name);
        }
    }
}

public class Q5_Product_Catalog_System {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TreeMap<Integer, Product> productMap = new TreeMap<>();

        System.out.println("Enter the number of products:");
        int n = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        for (int i = 0; i < n; i++) {
            System.out.println("Enter product id:");
            int id = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            System.out.println("Enter product name:");
            String name = scanner.nextLine();

            System.out.println("Enter product price:");
            double price = scanner.nextDouble();

            System.out.println("Enter product rating:");
            double rating = scanner.nextDouble();

            System.out.println("Enter product stock:");
            int stock = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            Product product = new Product(id, name, price, rating, stock);
            productMap.put(id, product);
        }

        List<Product> productList = new ArrayList<>(productMap.values());
        productList.sort(new ProductComparator());

        System.out.println("Sorted products by descending rating and then by name:");
        for (Product product : productList) {
            System.out.println(product);
        }
    }
}

