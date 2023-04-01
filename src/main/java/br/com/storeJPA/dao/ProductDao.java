package br.com.storeJPA.dao;

import br.com.storeJPA.model.Category;
import br.com.storeJPA.model.Product;

import javax.persistence.EntityManager;

import java.math.BigDecimal;
import java.util.List;

public class ProductDao implements Dao<Product> {
    private final EntityManager manager;

    public ProductDao (EntityManager entityManager) {
        this.manager = entityManager;
    }

    @Override
    public Product findUnique(long id) {
        return this.manager.find(Product.class, id);
    }

    @Override
    public List<Product> findMany(String search) {
        String jpql = "SELECT p FROM Product p WHERE p.name LIKE :name OR p.description LIKE :description";
        return manager.createQuery(jpql, Product.class)
                .setParameter("name", "%" + search + "%")
                .setParameter("description", "%" + search + "%")
                .getResultList();
    }

    public List<Product> findByCategoryName(String categoryName) {
        String jpql = "SELECT p FROM Product p WHERE p.category.name = :category";
        return manager.createQuery(jpql, Product.class).
                setParameter("category", categoryName.toUpperCase())
                .getResultList();
    }

    @Override
    public List<Product> getAll() {
        return this.manager.createQuery("SELECT p FROM Product p", Product.class).getResultList();
    }

    public BigDecimal getPriceByProductName(String name) {
        String jpql = "SELECT p.price FROM Product p WHERE p.name = :name";
        return this.manager.createQuery(jpql, BigDecimal.class)
                .setParameter("name", name)
                .getSingleResult();
    }

    @Override
    public void save(Product product) {
        this.manager.persist(product);
    }

    @Override
    public void update(Product product) {
        this.manager.merge(product);
    }

    @Override
    public void delete(Product product) {
        product = this.manager.merge(product);
        this.manager.remove(product);
    }
}
