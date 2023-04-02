package br.com.storeJPA.model;

import javax.persistence.*;

@Entity
@Table(name = "categories")
public class Category {

    @EmbeddedId
    private CategoryId id;

    public Category(String name) {
        this.id = new CategoryId(name, "xpto");
    }

    public Category() {}

    public String getName() {
        return id.getName();
    }

    public void setName(String name) {
        id.setName(name);
    }

    public CategoryId getId() {
        return id;
    }

    public void setId(CategoryId id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                '}';
    }
}
