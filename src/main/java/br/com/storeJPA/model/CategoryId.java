package br.com.storeJPA.model;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class CategoryId implements Serializable {

    private String name;
    private String type;

    public CategoryId() {}

    public CategoryId(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
