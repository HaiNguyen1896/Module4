package crud_jpa.Dao;

import crud_jpa.Model.Customer;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Component
@Transactional
public class CustomerDAO implements ICustomerDAO {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Customer> findAll() {
        return entityManager.createQuery("from Customer", Customer.class).getResultList();
    }

    @Override
    public Customer findCustomerByID(int id) {
        return entityManager.find(Customer.class, id);
    }

    @Override
    public void save(Customer customer) {
        entityManager.persist(customer);
    }

    @Override
    public void remove(Customer customer) {
        entityManager.remove(entityManager.contains(customer) ? customer : entityManager.merge(customer));
//        entityManager.remove(customer);
    }

    @Override
    public void edit(Customer customer) {
        entityManager.merge(customer);
    }

}
