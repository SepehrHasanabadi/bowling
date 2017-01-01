package shopdroid.equation;


import shopdroid.Product;
import shopdroid.ProductSpec;

import java.util.Iterator;
import java.util.Map;

/**
 * Created by Sepehr Hasanabadi
 */

public class Matcher implements Equation {

    @Override
    public boolean matches(ProductSpec productSpec, Product product) {
        if (productSpec.getProperties().entrySet().size() == 0)
            return false;

        for (Map.Entry<String, Object> entry : productSpec.getProperties().entrySet()) {
            if (product.getProductSpec().getProperty(entry.getKey()) == null ||
                    !product.getProductSpec().getProperty(entry.getKey())
                    .equals(productSpec.getProperty(entry.getKey())))
                return false;
        }

        return true;
    }
}
