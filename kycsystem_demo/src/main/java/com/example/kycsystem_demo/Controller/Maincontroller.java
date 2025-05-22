package com.example.kycsystem_demo.Controller;

import com.example.kycsystem_demo.Model.Customer;
import com.example.kycsystem_demo.Repository.CustomerRepository;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.hibernate.query.spi.QueryInterpretationCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.security.Key;
import java.util.List;
import java.util.Optional;

@RequestMapping("/Api/v1")
@RestController
public class Maincontroller {
    private String jwtSecret = "negasihadush";
    private Key getSigninkey(){
        byte[] keybaytes= Decoders.BASE64.decode(jwtSecret);
        return Keys.hmacShaKeyFor(keybaytes);
    }
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
    public ResponseEntity<String> registerCustomer(@Valid @RequestBody Customer customer  ){
        Customer customer1=new Customer();
        customer1.setFirstName(customer.getFirstName());
        customer1.setLastName(customer.getLastName());
        customer1.setProfession(customer.getProfession());
        customer1.setEmail(customer.getEmail());
        customer1.setAge(customer.getAge());
        customer1.setSalary(customer.getSalary());
        customer1.setGender(customer.getGender());
        customer1.setUsername(customer.getUsername());
        customer1.setPassword(customer.getPassword());
       crepository.save(customer1);
       return ResponseEntity.ok("Customer saved");
    }
    @PostMapping("/login")
    public Object login(@RequestBody Customer customer){
        List<Customer> customer1=crepository.findByusername(customer.getFirstName());
        return Jwts.builder()
                .subject(customer.getUsername())
                .signWith(getSigninkey())
                .claim("name", customer1)
                .compact();
    }
}
