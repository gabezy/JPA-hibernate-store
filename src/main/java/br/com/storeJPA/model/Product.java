package br.com.storeJPA.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity // tell JPA that this class is an entity(Table)
@Table(name = "products") // pass a different name to the table
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //
    private Long id;
    private String name;
    private String description;
    private BigDecimal price;
    private LocalDateTime createadAt = LocalDateTime.now();
    private LocalDateTime updateAt;

    @ManyToOne  //Categorization
    private Category category;


    public Product (String name, String description, BigDecimal price, Category category) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.category = category;
    }

    public Product(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public LocalDateTime getCreateadAt() {
        return createadAt;
    }

    public void setCreateadAt(LocalDateTime createadAt) {
        this.createadAt = createadAt;
    }

    public LocalDateTime getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(LocalDateTime updateAt) {
        this.updateAt = updateAt;
    }

    public Category getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return String.format("id: %d - name: %s - price: %f", this.id, this.name, this.price);
    }
}
