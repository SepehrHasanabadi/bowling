package shopdroid;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Sepehr Hasanabadi
 */

public class Category {

    private String name;
    private HashMap<String, Object> properties;
    private ArrayList<Product> products;

    public Category() {
        properties = new HashMap<>();
        products = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HashMap<String, Object> getProperties() {
        return properties;
    }

    public Object getProperty(String property) {
        return properties.get(property);
    }

    public void setProperties(HashMap<String, Object> properties) {
        this.properties = properties;
    }

    public void setProperty(String property) {
        setProperty(property, null);
    }

    public void setProperty(String property, Object value) {
        properties.put(property, value);
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public String toStringView() {
        ArrayList<ArrayList<String>> result = new ArrayList<>();

        for (Product product : getProducts()) {
            ArrayList<String> s = new ArrayList<>();
            s.add(product.getName());
            s.add(String.valueOf(product.getCost()));

            result.add(s);
        }

        return result.toString();
    }
}
