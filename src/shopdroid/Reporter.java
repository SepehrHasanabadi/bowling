package shopdroid;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Sepehr hasanabadi.
 */
public class Reporter {

    private ArrayList<Financial> financials;
    private static Reporter ourInstance = new Reporter();

    public static Reporter getInstance() {
        return ourInstance;
    }

    private Reporter() {
        financials = new ArrayList<>();
    }

    public void addFinancial(Financial financial) {
        financials.add(financial);
    }

    public ArrayList<Financial> getFinancials() {
        return financials;
    }

    public ArrayList<Financial> getFinancialsFromToDate(Date from, Date to) {
        ArrayList<Financial> result = new ArrayList<>();
        for (Financial financial : getFinancials()) {
            if (financial.getSellDate().after(from) && to.after(financial.getSellDate()))
                result.add(financial);
        }

        return result;
    }

    public String toStringViewReport() {
        ArrayList<String> result = new ArrayList<>();
        for (Financial financial : getFinancials()) {
            result.add(financial.toStringView());
        }

        return result.toString();
    }

    public String toStringViewReport(Date from, Date to) {
        ArrayList<String> result = new ArrayList<>();
        for (Financial financial : getFinancialsFromToDate(from, to)) {
            result.add(financial.toStringView());
        }

        return result.toString();
    }
}
