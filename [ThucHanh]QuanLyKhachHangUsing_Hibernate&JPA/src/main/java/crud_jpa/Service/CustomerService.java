package crud_jpa.Service;

import crud_jpa.Dao.CustomerDAO;
import crud_jpa.Dao.ICustomerDAO;
import crud_jpa.Model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CustomerService implements ICustomerService{
    @Autowired
    ICustomerDAO iCustomerDAO;

    @Override
    public List<Customer> findAll() {
        return iCustomerDAO.findAll();
    }

    @Override
    public Customer findCustomerByID(int id) {
        return iCustomerDAO.findCustomerByID(id);
    }

    @Override
    public void save(Customer customer) {
        iCustomerDAO.save(customer);
    }

    @Override
    public void remove(Customer customer) {
        iCustomerDAO.remove(customer);
    }

    @Override
    public void edit(Customer customer) {
        iCustomerDAO.edit(customer);
    }

}
