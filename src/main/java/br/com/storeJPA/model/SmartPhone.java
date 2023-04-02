package br.com.storeJPA.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;
@Entity
@Table(name = "smartphone")
public class SmartPhone extends Product{

    private String brand;
    private String model;

    public SmartPhone(){}
    public SmartPhone(String name, String description, BigDecimal price, Category category, String brand, String model) {
        super(name, description, price, category);
        this.brand = brand;
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}
