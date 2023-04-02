package br.com.storeJPA.dao;

import br.com.storeJPA.model.Client;

import javax.persistence.EntityManager;
import java.util.List;

public class ClientDao implements Dao<Client> {

    private final EntityManager manager;

    public ClientDao (EntityManager entityManager) {
        this.manager = entityManager;
    }

    @Override
    public Client findUnique(long id) {
        return manager.find(Client.class, id);
    }

    @Override
    public List<Client> findMany(String search) {
        return null;
    }

    @Override
    public List<Client> getAll() {
        return null;
    }

    @Override
    public void save(Client client) {
        manager.persist(client);
    }

    @Override
    public void update(Client client) {

    }

    @Override
    public void delete(Client client) {

    }
}
