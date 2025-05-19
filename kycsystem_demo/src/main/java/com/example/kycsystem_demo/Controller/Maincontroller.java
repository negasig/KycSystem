package com.example.kycsystem_demo.Controller;

import com.example.kycsystem_demo.Model.Customer;
import com.example.kycsystem_demo.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/Api/v1")
@RestController
public class Maincontroller {
    @Autowired
    CustomerRepository crepository;
    @GetMapping("/customers")
    public List<Customer> getCustomers(){
        return crepository.findAll();
    }
    @GetMapping("/customer/{id}")
    public Optional<Customer> getCustomerByid(@PathVariable int id){
        return crepository.findById(id);
    }
    @PostMapping("/addCustomer")
    public Customer registerCustomer(@RequestBody Customer customer){
        Customer customer1=new Customer();
        customer1.setFirstName(customer.getFirstName());
        customer1.setLastName(customer.getLastName());
        customer1.setProfession(customer.getProfession());
        customer1.setEmail(customer.getEmail());
        customer1.setAge(customer.getAge());
        customer1.setSalary(customer.getSalary());
        customer1.setGender(customer.getGender());
       return crepository.save(customer1);
    }
}
