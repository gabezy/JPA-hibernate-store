package br.com.storeJPA.dao;
import br.com.storeJPA.model.Product;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.math.BigDecimal;
import java.time.LocalDateTime;
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
        return manager.createNamedQuery("Product.productsByCategory", Product.class).
                setParameter("category", categoryName.toUpperCase())
                .getResultList();
    }

//    public List<Product> searchByParameters(String name, BigDecimal price, LocalDateTime createdAt) {
          // Using JPQL
//        String jpql = "SELECT p FROM Product p WHERE 1=1 ";
//        if (name != null && !name.trim().isEmpty()) {
//            jpql += "AND p.name = :name ";
//        }
//        if (price != null) {
//            jpql += "AND p.price = :price ";
//        }
//        if (createdAt != null) {
//            jpql += "AND p.createdAt = :createdAt";
//        }
//        TypedQuery<Product> query = manager.createQuery(jpql, Product.class);
//        if (name != null && !name.trim().isEmpty()) {
//            query.setParameter("name", name);
//        }
//        if (price != null) {
//            query.setParameter("price", price);
//        }
//        if (createdAt != null) {
//            query.setParameter("createdAt", createdAt);
//        }
//        return query.getResultList();
//    }
    public List<Product> searchByParameters(String name, BigDecimal price, LocalDateTime createdAt) {
        // Using Criteria API

       CriteriaBuilder builder = manager.getCriteriaBuilder();
       CriteriaQuery<Product> query =  builder.createQuery(Product.class);
       Root<Product> from = query.from(Product.class);
       Predicate filter = builder.and();
       if (name != null && !name.trim().isEmpty()) {
           filter =  builder.and(filter, builder.equal(from.get("name"), name));
       }
       if (price != null) {
           filter = builder.and(filter, builder.equal(from.get("price"), price));
       }
       if (createdAt != null) {
           filter = builder.and(filter, builder.equal(from.get("createdAt"), createdAt));
       }
       query.where(filter);
       return manager.createQuery(query).getResultList();
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
        product.setUpdatedAt(LocalDateTime.now());
    }

    @Override
    public void delete(Product product) {
        product = this.manager.merge(product);
        this.manager.remove(product);
    }
}
