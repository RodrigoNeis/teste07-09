package vo;

import java.util.List;

/**
 * Created by rneis on 07/09/2018.
 */
public class Sale extends BasicData {
    private String saleId;
    private List<SaleItem> saleItemList;
    private String salesManName;

    public Sale(String id, String saleId, List<SaleItem> saleItemList, String salesManName) {
        super(id);
        this.saleId = saleId;
        this.saleItemList = saleItemList;
        this.salesManName = salesManName;
    }

    public String getSaleId() {
        return saleId;
    }

    public List<SaleItem> getSaleItemList() {
        return saleItemList;
    }

    public String getSalesManName() {
        return salesManName;
    }

    public double totalValueOfSale() {
        double totalPrice = 0;
        for (SaleItem saleItem : saleItemList) {
            totalPrice += (saleItem.getPrice() * saleItem.getQuantity());
        }

        return totalPrice;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Sale=[");
        sb.append("id=[").append(getId()).append("]");
        sb.append("saleId=[").append(saleId).append("]");
        sb.append(", saleItemList=[").append(saleItemList).append("]");
        sb.append(", salesManName=[").append(salesManName).append("]");
        sb.append("]");
        return sb.toString();
    }
}