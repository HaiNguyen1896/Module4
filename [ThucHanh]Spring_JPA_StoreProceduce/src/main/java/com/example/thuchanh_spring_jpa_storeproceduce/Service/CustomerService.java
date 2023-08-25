package com.example.thuchanh_spring_jpa_storeproceduce.Service;

import com.example.thuchanh_spring_jpa_storeproceduce.CustomerDao.CustomerDAO;
import com.example.thuchanh_spring_jpa_storeproceduce.Model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    @Autowired
    CustomerDAO customerDAO;
    public boolean saveWithStoredProcedure(Customer customer){
       return customerDAO.saveWithStoredProcedure(customer);
    }
}
