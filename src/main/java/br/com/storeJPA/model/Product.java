package br.com.storeJPA.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity // tell JPA that this class is an entity(Table)
@Table(name = "products") // passing a different name to the table
@NamedQuery(
        name = "Product.productsByCategory",
        query = "SELECT p FROM Product p WHERE p.category.name = :category"
)
@Inheritance(strategy = InheritanceType.JOINED)
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //
    private Long id;
    private String name;
    private String description;
    private BigDecimal price;
    @Column(name = "created_at")
    private LocalDateTime createdAt = LocalDateTime.now();
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @ManyToOne(fetch = FetchType.LAZY)  //Categorization
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

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createadAt) {
        this.createdAt = createadAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updateAt) {
        this.updatedAt = updateAt;
    }

    public Category getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return String.format("id: %d - name: %s - price: %f", this.id, this.name, this.price);
    }
}
