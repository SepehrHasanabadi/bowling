package shopdriodtest;

import org.junit.Test;
import shopdroid.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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

        Date from = getDate("2016/1/1");
        Date to = getDate("2017/1/6");

        System.out.println(Reporter.getInstance().toStringViewReport(from, to));
        System.out.println(basket.getProducts().get(0).getProductSpec().getProperties().get("author"));
        System.out.println(basket.getProducts().get(0).getProductSpec().getProperties().get("pageCount"));
    }

    private Date getDate(String textDate) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/M/dd");
        Date date = null;
        try {
            date = sdf.parse(textDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return date;
    }

    public Product makeProduct() {
        Product product = new Product();
        product.setName("ebook");
        product.setCost(10000);
        ProductSpec productSpec = new ProductSpec();
        productSpec.setProperty("author", "hasanabadi");
        productSpec.setProperty("pageCount", 34);
        product.setProductSpec(productSpec);

        return product;
    }

}
