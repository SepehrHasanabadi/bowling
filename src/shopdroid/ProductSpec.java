package shopdroid;

import shopdroid.equation.Equation;
import shopdroid.equation.Matcher;

import java.util.HashMap;


/**
 * Created by Sepehr Hasanabadi
 */

public class ProductSpec {

    private HashMap<String, Object> properties;
    private Equation equation;

    public ProductSpec() {
        properties = new HashMap<>();
        equation = new Matcher();
    }

    public boolean matches(Product product) {
        return equation.matches(this, product);
    }

    public HashMap<String, Object> getProperties() {
        return properties;
    }

    public Object getProperty(String property) {
        return properties.get(property);
    }

    public void setProperties(HashMap<String, Object> properties) {
        this.properties = properties;
    }

    public void setProperty(String property) {
        setProperty(property, null);
    }

    public void setProperty(String property, Object value) {
        properties.put(property, value);
    }

}
