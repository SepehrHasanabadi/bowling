package shopdriodtest;

import org.junit.Test;
import shopdroid.Category;
import shopdroid.Inventory;
import shopdroid.Product;
import shopdroid.ProductSpec;

/**
 * Created by Sepehr hasanabadi.
 */
public class InventoryTester {

    @Test
    public void showInventory() {
        Inventory inventory = new Inventory();
        Category category = new Category();
        category.setName("Book");
        category.addProduct(makeProduct());
        category.addProduct(makeProduct());
        inventory.addCategory(category);
        inventory.addCategory(category);
        System.out.println(inventory.toStringViewReport());
    }

    public Product makeProduct() {
        Product product = new Product();
        product.setName("ebook");
        product.setCost(10000);
        ProductSpec productSpec = new ProductSpec();
        productSpec.setProperty("author", "hasanabadi");
        productSpec.setProperty("pageCount");
        product.setProductSpec(productSpec);

        return product;
    }
}
