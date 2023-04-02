import br.com.storeJPA.dao.CategoryDao;
import br.com.storeJPA.dao.ClientDao;
import br.com.storeJPA.dao.ProductDao;
import br.com.storeJPA.model.Category;
import br.com.storeJPA.model.Product;
import br.com.storeJPA.util.JPAUtil;
import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;

public class RegisterProduct {

    public static void main(String[] args) {

        PopulateDatabase.populateProduct();
        long id = 1L;

        EntityManager manager = JPAUtil.getEntityManager();
        ProductDao productDao = new ProductDao(manager);

        System.out.println(productDao.findUnique(id));
        List<Product> productList = productDao.getAll();
        productList.forEach(System.out::println);
        System.out.println();


        System.out.println("Search by name and Description");

        productDao.findMany("64").forEach(System.out::println);
        System.out.println();

        System.out.println("Search by category name");
        productDao.findByCategoryName("smartphone").forEach(System.out::println);

        System.out.println(productDao.getPriceByProductName("Iphone 13"));


    }


}
