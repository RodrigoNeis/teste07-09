package process;

import vo.BasicData;
import vo.Client;
import vo.Sale;
import vo.SalesMan;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by rneis on 07/09/2018.
 */
public class Analytics {
    private List<BasicData> basicDataList;

    public Analytics(List<BasicData> basicDataList) {
        this.basicDataList = basicDataList;
    }

    public int getNumberOfClients() {
        int total = 0;
        for (BasicData basicData : basicDataList) {
            if (basicData instanceof Client) {
                total++;
            }
        }
        return total;
    }

    public int getNumberOfSalesMan() {
        int total = 0;
        for (BasicData basicData : basicDataList) {
            if (basicData instanceof SalesMan) {
                total++;
            }
        }
        return total;
    }

    public String getTheSaleIdOfTheMostExpensiveSale() {
        Sale mostExpensiveSale = null;
        for (BasicData basicData : basicDataList) {
            if (basicData instanceof Sale) {
                Sale sale = (Sale) basicData;
                if (mostExpensiveSale == null || mostExpensiveSale.totalValueOfSale() < sale.totalValueOfSale()) {
                    mostExpensiveSale = sale;
                }
            }
        }
        return mostExpensiveSale.getSaleId();
    }

    public SalesMan getWorstSalesMan() {
        String salesName = null;
        Double value = null;
        for (Map.Entry<String, Double> entry : getHashSalesManNameAndTotalSales().entrySet()) {

            String key = entry.getKey();
            Double mapValue = entry.getValue();
            if (salesName == null && value == null) {
                salesName = key;
                value = mapValue;
            }
            if (value > mapValue) {
                value = mapValue;
                salesName = key;
            }
        }
        return getSalesManByName(salesName);

    }

    private HashMap<String, Double> getHashSalesManNameAndTotalSales() {
        HashMap<String, Double> map = new HashMap<String, Double>();
        for (BasicData basicData : basicDataList) {
            if (basicData instanceof Sale) {
                Sale sale = (Sale) basicData;
                if (map.containsKey(sale.getSalesManName())) {
                    Double value = map.get(sale.getSalesManName());
                    value += sale.totalValueOfSale();
                    map.put(sale.getSalesManName(), value);
                } else {
                    map.put(sale.getSalesManName(), sale.totalValueOfSale());
                }
            }
        }
        return map;
    }

    private SalesMan getSalesManByName(String name) {
        for (BasicData basicData : basicDataList) {
            if (basicData instanceof SalesMan) {
                SalesMan salesMan = (SalesMan) basicData;
                if (name.equals(salesMan.getName())) {
                    return salesMan;
                }
            }
        }
        return null;
    }
}
