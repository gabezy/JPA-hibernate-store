package br.com.storeJPA.dao;

import br.com.storeJPA.model.Order;
import br.com.storeJPA.vo.SalesReportVo;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;

public class OrderDao implements Dao<Order> {

    private final EntityManager manager;

    public OrderDao (EntityManager entityManager) {
        this.manager = entityManager;
    }

    @Override
    public Order findUnique(long id) {
        return null;
    }

    @Override
    public List<Order> findMany(String search) {
        return null;
    }

    @Override
    public List<Order> getAll() {
        return null;
    }

    public BigDecimal getOrderTotalValue () {
        String jpql = "SELECT SUM(o.totalValue) FROM Order o";
        return manager.createQuery(jpql, BigDecimal.class).getSingleResult();
    }

    public List<SalesReportVo> getSalesReport() {
        String jpql = "SELECT new br.com.storeJPA.vo.SalesReportVo( " +
                "p.name, SUM(i.quantity), MAX(o.orderAt)) FROM Order o " +
                "JOIN o.items i " +
                "JOIN i.product p " +
                "GROUP BY p.name " +
                "ORDER BY SUM(i.quantity) DESC";
        return manager.createQuery(jpql, SalesReportVo.class).getResultList();
    }

    public Order getOrderWithClient(long id) {
        return manager.createQuery(
                "SELECT o From Order o JOIN FETCH o.client WHERE o.id = :id",
                Order.class
        ).setParameter("id", id).getSingleResult();
    }

    @Override
    public void save(Order order) {
        manager.persist(order);
    }

    @Override
    public void update(Order order) {

    }

    @Override
    public void delete(Order order) {

    }
}
