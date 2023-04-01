import br.com.storeJPA.dao.CategoryDao;
import br.com.storeJPA.dao.ProductDao;
import br.com.storeJPA.model.Category;
import br.com.storeJPA.model.Product;
import br.com.storeJPA.util.JPAUtil;
import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;

public class RegisterProduct {

    public static void main(String[] args) {

        registerProduct();
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
        productDao.findByCategoryName("ios").forEach(System.out::println);

        System.out.println(productDao.getPriceByProductName("Iphone 13"));


    }

    private static void registerProduct() {
        Category ios = new Category("IOS");
        Category android = new Category("ANDROID");
        Product xiaomi = new Product("Xiaomi Redmi", "Xiomi Redmi 64GB",
                new BigDecimal("1200"), android
        );
        Product iphone = new Product("Iphone 13", "Iphone 13 plus 64GB",
                    new BigDecimal("5000.32"), ios
                );
        Product iphone2 = new Product("Iphone 13", "Iphone 13 plus 128GB",
                new BigDecimal("7000"), ios
        );

        EntityManager manager = JPAUtil.getEntityManager();

        CategoryDao categoryDao = new CategoryDao(manager);
        ProductDao productDao = new ProductDao(manager);

        // save the product in the products table
        manager.getTransaction().begin();


        categoryDao.save(ios);
        categoryDao.save(android);
        productDao.save(xiaomi);
        productDao.save(iphone);
//        productDao.save(iphone2);

        manager.getTransaction().commit();
        manager.close();
    }
}
