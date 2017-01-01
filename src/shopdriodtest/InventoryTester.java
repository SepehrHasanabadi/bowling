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
        Category category = new Category();
        category.setName("Book");
        category.addProduct(makeProduct());
        category.addProduct(makeProduct());

        Category c = new Category();
        c.setName("News Paper");
        c.addProduct(makeProduct());
        c.addProduct(makeProduct());

        Inventory inventory = new Inventory();
        inventory.addCategory(category);
        inventory.addCategory(c);

        System.out.println(inventory.toStringViewReport());
    }

    public Product makeProduct() {
        Product product = new Product();
        product.setName("ebook");
        product.setCost(10000);
        ProductSpec productSpec = new ProductSpec();
        productSpec.setProperty("author", "hasanabadi");
        productSpec.setProperty("pageCount", 12);
        product.setProductSpec(productSpec);

        return product;
    }
}
