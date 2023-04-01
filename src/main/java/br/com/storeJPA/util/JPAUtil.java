package br.com.storeJPA.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {

    private static final EntityManagerFactory FACTORY = Persistence.createEntityManagerFactory("storeJPA");

    public static EntityManager getEntityManager() {
        return FACTORY.createEntityManager();
    }
}
