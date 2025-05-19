package com.example.kycsystem_demo.Controller;

import com.example.kycsystem_demo.Model.Customer;
import com.example.kycsystem_demo.Repository.CustomerRepository;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/Api/v1")
@RestController
public class Maincontroller {
    @Autowired
    CustomerRepository crepository;
    @GetMapping("/customers")
    public Object getCustomers(){
        List<Customer> lc=crepository.findAll();
        if(lc.size()<1){
            return "No records";
        }
        else {
            return lc;
        }
    }
    @GetMapping("/customer/{id}")
    public Object getCustomerByid(@PathVariable int id){
        Optional<Customer> lc=crepository.findById(id);
        if(lc.isEmpty()){
            return "No record found with id  " +id;
        }
        else {
            return lc;
        }
    }
    @PostMapping("/addCustomer")
    public Customer registerCustomer(@NotNull @Valid @RequestBody Customer customer  ){
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
    @PostMapping("/login")
    public String login(){
        return "Loged in";
    }
}
