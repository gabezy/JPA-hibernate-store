package br.com.storeJPA.dao;

import java.util.List;

public interface Dao<T> {
     T findUnique(long id);
     List<T> findMany(String search);
     List<T> getAll();
    void save (T t);
    void update(T t);
    void delete (T t);
}
