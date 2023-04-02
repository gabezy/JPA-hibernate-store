package br.com.storeJPA.model;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "items_order")
public class ItemOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "unit_price")
    private BigDecimal unitPrice;
    private int quantity;
    @ManyToOne(fetch = FetchType.LAZY)
    private Order order;
    @ManyToOne(fetch = FetchType.LAZY)
    private Product product;

    public ItemOrder() {
    }

    public ItemOrder(int quantity, Order order, Product product) {
        this.quantity = quantity;
        this.order = order;
        this.unitPrice = product.getPrice();
        this.product = product;
    }

    public BigDecimal getTotalItemOrderValue() {
        return this.unitPrice.multiply(new BigDecimal(this.quantity));
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
