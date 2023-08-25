package com.example.thuchanh_spring_jpa_storeproceduce.CustomerDao;

import com.example.thuchanh_spring_jpa_storeproceduce.Model.Customer;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

@Repository
@Transactional
public class CustomerDAO {
    @PersistenceContext
    private EntityManager entityManager;

    public boolean saveWithStoredProcedure(Customer customer) {
        String sql = "CALL Insert_Customer(:first_name, :last_name)";
        Query query = entityManager.createNativeQuery(sql);
        query.setParameter("first_name", customer.getFirstName());
        query.setParameter("last_name", customer.getLastName());
        return query.executeUpdate() != 0;
    }

}
