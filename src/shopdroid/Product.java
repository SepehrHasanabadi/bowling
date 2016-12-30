package shopdroid;

import shopdroid.comparison.Comparison;
import shopdroid.comparison.CostComparison;

/**
 * Created by Sepehr Hasanabadi
 */

public class Product {

    private String name;
    private Integer cost;
    private ProductSpec productSpec;
    private Comparison comparison;

    public Product() {
        comparison = new CostComparison();
    }

    public boolean isMoreCost(Product product) {
        return comparison.isGraterThan(this, product);
    }

    public ProductSpec getProductSpec() {
        return productSpec;
    }

    public void setProductSpec(ProductSpec productSpec) {
        this.productSpec = productSpec;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }
}
