package shopdroid;

import java.util.ArrayList;

/**
 * Created by Sepehr Hasanabadi
 */

public class Inventory {

    private ArrayList<Category> categories;

    public Inventory() {
        categories = new ArrayList<>();
    }

    public ArrayList<Category> getCategories() {
        return categories;
    }

    public void addCategory(Category category) {
        categories.add(category);
    }

    public String toStringViewReport() {
        ArrayList<String> result = new ArrayList<>();
        for (Category category : getCategories()) {
            result.add(category.getName());
            result.add(category.toStringView());
        }

        return result.toString();
    }

    public ArrayList<Product> search(ProductSpec productSpec) {
        ArrayList<Product> result = new ArrayList<>();
        for (Category category : categories){
            for (Product product: category.getProducts()){
                if (productSpec.matches(product))
                    result.add(product);
            }
        }

        return result;
    }
}
