import br.com.storeJPA.dao.ClientDao;
import br.com.storeJPA.dao.OrderDao;
import br.com.storeJPA.dao.ProductDao;
import br.com.storeJPA.model.*;
import br.com.storeJPA.util.JPAUtil;
import br.com.storeJPA.vo.SalesReportVo;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;

public class RegsiterOrder {

    public static void main(String[] args) {
        PopulateDatabase.populateClient();

        EntityManager manager = JPAUtil.getEntityManager();
        ProductDao productDao = new ProductDao(manager);
        OrderDao orderDao = new OrderDao(manager);
        ClientDao clientDao = new ClientDao(manager);

        manager.getTransaction().begin();

        Client client = clientDao.findUnique(1);
        Product xiaomi = productDao.findUnique(1);
        Product iphone = productDao.findUnique(2);
        Product cs2 = productDao.findUnique(3);
        Product pc = productDao.findUnique(4);




        Order order = new Order(client);
        order.addItem(new ItemOrder(10, order, xiaomi));
        order.addItem(new ItemOrder(10, order, iphone));
        orderDao.save(order);

        Order order1 = new Order(client);
        order1.addItem(new ItemOrder(2, order1, cs2));
        order1.addItem(new ItemOrder(2, order1, pc));
        orderDao.save(order1);

        manager.getTransaction().commit();

        BigDecimal totalSold = orderDao.getOrderTotalValue();

        System.out.println(totalSold);

        List<SalesReportVo> reportList =  orderDao.getSalesReport();
        reportList.forEach(System.out::println);

        manager.close();

    }



}
