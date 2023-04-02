import br.com.storeJPA.dao.ClientDao;
import br.com.storeJPA.dao.OrderDao;
import br.com.storeJPA.model.Order;
import br.com.storeJPA.util.JPAUtil;
import javax.persistence.EntityManager;

public class PerformanceQuery {

    public static void main(String[] args) {
        PopulateDatabase.populateOrder();
        EntityManager manager = JPAUtil.getEntityManager();
        OrderDao orderDao = new OrderDao(manager);
        ClientDao clientDao = new ClientDao(manager);
        Order order = orderDao.getOrderWithClient(1L);

        System.out.println(clientDao.findUnique(1));

        manager.close();
        System.out.println(order.getClient().getName());
    }
}
