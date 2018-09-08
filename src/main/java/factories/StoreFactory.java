package factories;

import vo.BasicData;
import vo.Client;
import vo.Sale;
import vo.SaleItem;
import vo.SalesMan;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rneis on 07/09/2018.
 */
public class StoreFactory {
    private static final String SALESMAN_ID = "001";
    private static final String CLIENT_ID = "002";
    private static final String SALE_ID = "003";
    private String line;

    public StoreFactory(String line) {
        this.line = line;
    }

    public BasicData getObject() {
        String[] columns = this.line.split("ç");
        String id = "";
        BasicData basicData = null;

        if (columns.length >= 1) {
            id = columns[0];
        }

        if (SALESMAN_ID.equals(id)) {
            basicData = buildSalesMan(columns);
        } else if (CLIENT_ID.equals(id)) {
            basicData = buildClient(columns);
        } else if (SALE_ID.equals(id)) {
            basicData = buildSale(columns);
        }

        return basicData;
    }

    private BasicData buildSalesMan(String[] columns) {
        return new SalesMan(columns[0], columns[1], columns[2], Double.valueOf(columns[3]));
    }

    private BasicData buildClient(String[] columns) {
        return new Client(columns[0], columns[1], columns[2], columns[3]);
    }

    private BasicData buildSale(String[] columns) {
        return new Sale(columns[0], columns[1], buildItems(columns[2]), columns[3]);
    }

    private List<SaleItem> buildItems(String column) {
        String itemsString = column.substring(column.indexOf("[") + 1, column.indexOf("]"));
        String itemsColumns[] = itemsString.split(",");
        List<SaleItem> saleItemsObj = new ArrayList<SaleItem>();

        for (int i = 0; i < itemsColumns.length; i++) {
            String itemValues[] = itemsColumns[i].split("-");
            saleItemsObj.add(new SaleItem(itemValues[0], Integer.valueOf(itemValues[1]), Double.valueOf(itemValues[2])));
        }

        return saleItemsObj;
    }
}
