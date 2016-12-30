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
}
