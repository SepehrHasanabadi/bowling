package shopdroid;

import jdk.nashorn.api.scripting.JSObject;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Sepehr Hasanabadi
 */

public class Financial {

    private Date sellDate;
    private Basket basket;

    public Basket getBasket() {
        return basket;
    }

    public void setBasket(Basket basket) {
        this.basket = basket;
    }

    public Date getSellDate() {
        return sellDate;
    }

    public void setSellDate(Date sellDate) {
        this.sellDate = sellDate;
    }

    public Date getToday() {
        return Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant());
    }

    public void sell() {
        setSellDate(getToday());
        Reporter.getInstance().addFinancial(this);
    }

    public String toStringView() {
        ArrayList<ArrayList<String>> result = new ArrayList<>();

        for (Product product : getBasket().getProducts()) {
            ArrayList<String> s = new ArrayList<>();
            s.add(product.getName());
            s.add(String.valueOf(product.getCost()));
            s.add(getSellDateString());

            result.add(s);
        }

        return result.toString();
    }

    public String getSellDateString() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        return dateFormat.format(getSellDate());
    }
}
