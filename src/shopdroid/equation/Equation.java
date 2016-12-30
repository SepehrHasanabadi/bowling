package shopdroid.equation;

import shopdroid.Product;
import shopdroid.ProductSpec;

/**
 * Created by Sepehr Hasanabadi
 */

public interface Equation {

    boolean matches(ProductSpec productSpec, Product product);
}
