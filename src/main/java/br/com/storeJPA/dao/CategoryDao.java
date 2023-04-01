package br.com.storeJPA.dao;

import br.com.storeJPA.model.Category;
import br.com.storeJPA.model.Product;

import javax.persistence.EntityManager;
import java.util.List;

public class CategoryDao implements Dao<Category> {

    private final EntityManager manager;

    public CategoryDao(EntityManager entityManager) {
        this.manager = entityManager;
    }

    @Override
    public Category findUnique(long id) {
        return this.manager.find(Category.class, id);
    }

    @Override
    public List<Category> findMany(String search) {
        return null;
    }

    @Override
    public List<Category> getAll() {
        return this.manager.createQuery("SELECT p FROM Product p", Category.class).getResultList();
    }

    @Override
    public void save(Category category) {
        this.manager.persist(category);
    }

    @Override
    public void update(Category category) {
        this.manager.merge(category);
    }

    @Override
    public void delete(Category category) {
        category = this.manager.merge(category);
        this.manager.remove(category);
    }
}
