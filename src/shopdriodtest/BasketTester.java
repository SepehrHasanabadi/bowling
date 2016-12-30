package shopdriodtest;

import org.junit.Test;
import shopdroid.*;

/**
 * Created by Sepehr hasanabadi.
 */
public class BasketTester {

    @Test
    public void createBasket() {
        Basket basket = new Basket();
        basket.addProduct(makeProduct());
        basket.addProduct(makeProduct());
        Financial financial = new Financial();
        financial.setBasket(basket);
        financial.sell();
        System.out.println(Reporter.getInstance().toStringViewReport());
        System.out.println(basket.getProducts().get(0).getProductSpec().getProperties().get("author"));
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
