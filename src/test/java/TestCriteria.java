import br.com.storeJPA.dao.ProductDao;
import br.com.storeJPA.model.Product;
import br.com.storeJPA.util.JPAUtil;

import javax.persistence.EntityManager;
import java.time.LocalDateTime;
import java.util.List;

public class TestCriteria {

    public static void main(String[] args) {
        PopulateDatabase.populateProduct();
        EntityManager manager = JPAUtil.getEntityManager();
        ProductDao productDao = new ProductDao(manager);
        List<Product> products = productDao.searchByParameters(null, null, LocalDateTime.now());
        products.forEach(System.out::println);
    }
}
