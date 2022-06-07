import java.util.*;

class ProductService {
    public static ArrayList<Product> products = Product.getProductsList();
    String productName;
    double temp = 0.00;
    Product product_object, temp_obj;
    ArrayList<Product> newList = new ArrayList<>();

    public String findNameCode(int productCode) {
        products.forEach(a -> {
            if (productCode == a.getProductCode())
                productName = a.getName();
            else
                productName = null;
        });
        return ("Product Name: " + productName);
    }

    public Product findMaxPriceofProduct(String category) {
        products.forEach(a -> {
            if (Objects.equals(category, a.getCategory())) {
                product_object = a;
                if (temp < a.getPrice()) {
                    temp = a.getPrice();
                    temp_obj = a;
                }
            } else {
                product_object = null;
            }
        });
        return (temp_obj);
    }

    public ArrayList<Product> getProductsCategory(String category) {
        products.forEach(a -> {
            if (Objects.equals(category, a.getCategory()))
                newList.add(a);
            else
                product_object = null;
        });
        return newList;
    }
}

public class Product {
    private int productCode;
    private String name;
    private double price;
    private String category;

    public Product(int productCode, String name, double price, String category) {
        this.productCode = productCode;
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public int getProductCode() {
        return productCode;
    }

    public void setProductCode(int productCode) {
        this.productCode = productCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public static ArrayList<Product> getProductsList() {
        ArrayList<Product> products = new ArrayList<>();
        products.add(new Product(011, "Fan", 2999.00, "electronics"));
        products.add(new Product(012, "Cooler", 7999.00, "electronics"));
        products.add(new Product(013, "Air conditioner", 39999.00, "electronics"));
        products.add(new Product(021, "Mac", 99999.00, "laptop"));
        products.add(new Product(022, "Lenovo", 49999.00, "laptop"));
        products.add(new Product(023, "HP", 59000.00, "laptop"));
        products.add(new Product(031, "Shirt", 1199.00, "Clothes"));
        products.add(new Product(032, "Pant", 15999.00, "Clothes"));
        products.add(new Product(033, "Trousers", 1999.00, "Clothes"));
        return products;
    }

    public static void main(String[] args) {
        ProductService productService = new ProductService();
        ArrayList<Product> products = productService.getProductsCategory("laptop");
        if (products != null) {
            for (Product product : products) {
                System.out.println("[ Product code is: " + product.getProductCode() + ", Product name is: "
                        + product.getName() + ", Product price is: Rs." + product.getPrice() + ", Product category is: "
                        + product.getCategory() + " ]");
            }
        }
    }

}