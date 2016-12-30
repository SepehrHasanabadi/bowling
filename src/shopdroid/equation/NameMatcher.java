package shopdroid.equation;


import shopdroid.Product;
import shopdroid.ProductSpec;

/**
 * Created by Sepehr Hasanabadi
 */

public class NameMatcher implements Equation {


    @Override
    public boolean matches(ProductSpec productSpec, Product product) {
        return false;
    }
}
