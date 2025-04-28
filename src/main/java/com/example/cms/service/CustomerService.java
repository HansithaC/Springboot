package com.example.cms.service;

import com.example.cms.dao.CustomerDao;
import com.example.cms.exception.CustomerException;
import com.example.cms.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.Consumer;

@Component
public class CustomerService {
    @Autowired

    private CustomerDao customerDao;

    //private int customerIdCount = 1;
    //private List<Customer> customerList = new CopyOnWriteArrayList<>();

    public Customer addcustomer(Customer customer){
        /*customer.setCustomerId(customerIdCount);
        customerList.add(customer);
        customerList.add(customer);
        customerIdCount++;*/
        return customerDao.save(customer);
        //return customer;
    }
    public List<Customer> getCustomerList(){
       return customerDao.findAll();
        //return customerList;
    }
    public Customer getCustomer(int customerId){
        /*customerList
                .stream()
                .filter(c -> c.getCustomerId() == customerId)
                .findFirst()
                .get();*/
        Optional<Customer> optionalCustomer = customerDao.findById(customerId);
        if(!optionalCustomer.isPresent())
            throw new CustomerException("Customer not found......");
        return optionalCustomer.get();





    }
    public Customer updatecustomer(int customerId, Customer customer){
        customer.setCustomerId(customerId);
        /*customerList
                .stream()
                 .forEach(c -> {
                     if(c.getCustomerId() == customerId){
                         c.setCustomerFirstName(customer.getCustomerFirstName());
                         c.setCustomerLastName(customer.getCustomerLastName());
                         c.setCustomerEmail(customer.getCustomerEmail());

                     }
                 });
         return customerList
                 .stream()
                 .filter(c -> c.getCustomerId() == customerId)
                 .findFirst()
                .get();*/
        return customerDao.save(customer);


    }
    public void deleteCustomer(int customerId){
        /*customerList
                .stream()
                .forEach(c -> {
                    if(c.getCustomerId() == customerId){
                        customerList.remove(c);
                    }
                });*/
        customerDao.deleteById(customerId);
    }

    


    public List<Customer> getCustomers() {
        List<Customer> customerList = List.of();
        return customerList;
    }



    public Customer updateCustomer(int customerId, Customer customer) {
        return updatecustomer(customerId, customer);
    }
}