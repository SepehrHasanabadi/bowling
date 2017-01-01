package shopdriodtest;

import org.junit.Test;
import shopdroid.Product;
import shopdroid.ProductSpec;

/**
 * Created by Sepehr hasanabadi.
 */
public class SearchTester {

    @Test
    public void search() {
        ProductSpec productSpec = new ProductSpec();
        productSpec.setProperty("name", "ali");
        productSpec.setProperty("author", "mammad");

        ProductSpec ps = new ProductSpec();
        ps.setProperty("name", "ali");
        ps.setProperty("author", "mammad");
        Product product = new Product();
        product.setProductSpec(ps);

        System.out.println(productSpec.matches(product));
    }
}
