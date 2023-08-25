package Service;

import Model.Customer;

import java.util.ArrayList;
import java.util.List;

public class CustomerService {
    public List<Customer> customerList;
    public CustomerService(){
        customerList = new ArrayList<>();
        customerList.add(new Customer(1,"Nguyen Khac Nhat","Nhat@codegym.vn","Ha Noi"));
        customerList.add(new Customer(2,"Dang Huy Ha","Hoa@codegym.vn","Đà Nẵng"));
        customerList.add(new Customer(3,"Le Thi Chau","Chau_Le@codegym.vn","Ha Noi"));
        customerList.add(new Customer(4,"Nguyen Thuy Duong","Duong.Nguyen@codegym.vn","Sài Gòn"));
        customerList.add(new Customer(5,"Codegym","codegym@codegym.vn","Việt Nam"));
    }
    public Customer findCustomerByID(int id){
        for(Customer customer : customerList){
            if(customer.getId()==id){
                return customer;
            }
        }
        return null;
    }
    public void edit(Customer customer){
        Customer tempCustomer = findCustomerByID(customer.getId());
        tempCustomer.setName(customer.getName());
        tempCustomer.setEmail(customer.getEmail());
        tempCustomer.setAddress(customer.getAddress());
    }

}
