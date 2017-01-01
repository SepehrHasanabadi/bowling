package shopdriodtest;

import org.junit.Test;
import shopdroid.Product;
import shopdroid.ProductSpec;

/**
 * Created by Sepehr hasanabadi.
 */
public class Comparasion {

    @Test
    public void compareProducts() {
        Product product = firstProduct();
        System.out.println(product.isMoreCost(secondProduct()));
    }

    public Product firstProduct() {
        Product product = new Product();
        product.setName("ebook");
        product.setCost(10000);
        ProductSpec productSpec = new ProductSpec();
        productSpec.setProperty("author", "hasanabadi");
        productSpec.setProperty("pageCount", 13);
        product.setProductSpec(productSpec);

        return product;
    }

    public Product secondProduct() {
        Product product = new Product();
        product.setName("news paper");
        product.setCost(1200);
        ProductSpec productSpec = new ProductSpec();
        productSpec.setProperty("author", "karim");
        productSpec.setProperty("pageCount", 34);
        product.setProductSpec(productSpec);

        return product;
    }
}
