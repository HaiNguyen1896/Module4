package crud_jpa.Dao;

import crud_jpa.Model.Customer;

import java.util.List;

public interface IGenerateRepo<T> {
    List<T> findAll();
    T findCustomerByID(int id);
    void save(T t);
    void remove(T t);
    void edit(T t);
}
