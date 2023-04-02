package br.com.storeJPA.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "total_value")
    private BigDecimal totalValue = BigDecimal.ZERO;
    @Column(name = "order_at")
    private LocalDateTime orderAt = LocalDateTime.now();

    @ManyToOne(fetch = FetchType.LAZY)
    private Client client;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<ItemOrder> items = new ArrayList<>();

    public Order(){}

    public Order(Client client) {
        this.client = client;
    }
    public void addItem(ItemOrder item) {
        item.setOrder(this);
        this.items.add(item);
        this.totalValue = this.totalValue.add(item.getTotalItemOrderValue());
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDateTime getOrderAt() {
        return orderAt;
    }

    public void setOrderAt(LocalDateTime orderAt) {
        this.orderAt = orderAt;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public BigDecimal getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(BigDecimal totalValue) {
        this.totalValue = totalValue;
    }

    public List<ItemOrder> getItems() {
        return items;
    }
}
