import br.com.storeJPA.dao.CategoryDao;
import br.com.storeJPA.dao.ClientDao;
import br.com.storeJPA.dao.OrderDao;
import br.com.storeJPA.dao.ProductDao;
import br.com.storeJPA.model.*;
import br.com.storeJPA.util.JPAUtil;

import javax.persistence.EntityManager;
import java.math.BigDecimal;

public class PopulateDatabase {
    public static void populateProduct() {
        Category smartphone = new Category("SMARTPHONE");
        Category videogame = new Category("VIDEOGAME");
        Category computer = new Category("COMPUTER");

        Product xiaomi = new Product(
                "Xiaomi Redmi", "Xiomi Redmi 64GB",
                new BigDecimal("1200"), smartphone
        );
        Product iphone = new Product(
                "Iphone 13", "Iphone 13 plus 64GB",
                new BigDecimal("5000.32"), smartphone
        );
        Product cs2 = new Product(
                "Counter:Strike 2", "CS2",
                new BigDecimal("100"), videogame
        );
        Product pc = new Product(
                "PC gamer", "Intel 13th gen, rtx 3090 16GB ram",
                new BigDecimal("10000"), computer
        );
        EntityManager manager = JPAUtil.getEntityManager();

        CategoryDao categoryDao = new CategoryDao(manager);
        ProductDao productDao = new ProductDao(manager);

        // save the product in the products table
        manager.getTransaction().begin();


        categoryDao.save(smartphone);
        categoryDao.save(videogame);
        categoryDao.save(computer);

        productDao.save(xiaomi);
        productDao.save(iphone);
        productDao.save(cs2);
        productDao.save(pc);

        manager.getTransaction().commit();
        manager.close();
    }

    public static void populateClient() {
        populateProduct();
        Client client = new Client("Rodrigo", 30, "131321321");


        EntityManager manager = JPAUtil.getEntityManager();
        ClientDao clientDao = new ClientDao(manager);

        manager.getTransaction().begin();
        clientDao.save(client);
        manager.getTransaction().commit();
        manager.close();
    }

    public static void populateOrder() {
        populateProduct();
        populateClient();
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
    }

}
