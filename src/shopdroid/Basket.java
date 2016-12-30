package shopdroid;

import java.util.ArrayList;

/**
 * Created by Sepehr hasanabadi.
 */
public class Basket {

    private ArrayList<Product> products;

    public Basket() {
        products = new ArrayList<>();
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void clearBasket() {
        products = new ArrayList<>();
    }

}
