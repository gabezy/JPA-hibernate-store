package br.com.storeJPA.vo;


import java.time.LocalDateTime;

public class SalesReportVo {
    private String productName;
    private long totalQuantity;
    private LocalDateTime lastOrder;

    public SalesReportVo(String productName, long totalQuantity, LocalDateTime lastOrder) {
        this.productName = productName;
        this.totalQuantity = totalQuantity;
        this.lastOrder = lastOrder;
    }

    @Override
    public String toString() {
        return "SalesReportVo{" +
                "productName='" + productName + '\'' +
                ", totalQuantity=" + totalQuantity +
                ", lastOrder=" + lastOrder +
                '}';
    }

    public String getProductName() {
        return productName;
    }

    public long getTotalQuantity() {
        return totalQuantity;
    }

    public LocalDateTime getLastOrder() {
        return lastOrder;
    }
}
