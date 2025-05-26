package com.example.kycsystem_demo.Controller;

import com.example.kycsystem_demo.Model.Customer;
import com.example.kycsystem_demo.Model.UserDTO;
import com.example.kycsystem_demo.Ratelimitservice;
import com.example.kycsystem_demo.Repository.CustomerRepository;
import io.github.bucket4j.Bucket;
import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import javax.crypto.SecretKey;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static io.jsonwebtoken.Jwts.*;

@RequestMapping("/Api/v1")
@RestController
@Data
public class Maincontroller {
    private String jwtSecret = "negasihadusdfsjfsadfsdgfsjgfshdfsgfsgfdsgfg2526485634573563845638456358345634sh";

    private SecretKey getSigninkey() {
        byte[] keybaytes = Decoders.BASE64.decode(jwtSecret);
        return Keys.hmacShaKeyFor(keybaytes);
    }

    @Autowired
    CustomerRepository crepository;
    @Autowired
    Ratelimitservice ratelimitservice;

    @GetMapping("/customers")
    public Object getCustomers() {
        List<Customer> lc = crepository.findAll();
        if (lc.size() < 1) {
            return "No records";
        } else {
            return lc;
        }
    }

    @GetMapping("/customer/{id}")

    public ResponseEntity<UserDTO> getCustomerByid(@PathVariable @Positive int id) {
            Customer lc =crepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
            UserDTO userDTO=new UserDTO(lc.getFirstName(),lc.getLastName(),lc.getProfession(),lc.getAge(),lc.getGender());
            return ResponseEntity.ok(userDTO);
    }

    @PostMapping("/addCustomer")

    public ResponseEntity<String> registerCustomer(@Valid @RequestBody Customer customer  ) {
        List<Customer> customer11 = crepository.findByusername(customer.getUsername());
        if (customer11.isEmpty()) {

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
        else {
            return ResponseEntity.ok("user already exists");

        }
    }
@PostMapping("/login")
    public Object login(@RequestBody Customer customer){
    Map<String, String> users=new HashMap<>();
        List<Customer> customer1=crepository.findByusername(customer.getUsername());
        if (customer1.size()==1){
            users.put("role",customer1.get(0).getRole());
            users.put("username", customer1.get(0).getUsername());
        }
        if(customer1.get(0).getUsername().equals(customer.getUsername())
                && customer1.get(0).getPassword().equals(customer.getPassword())){
            return Jwts.builder()
                    .setSubject(customer.getUsername())
                    .signWith(SignatureAlgorithm.HS256, jwtSecret)
                    .setClaims(users)
                    .compact();
        }
        else {
            return "you have enterd incorrect credientials";
        }
    }

    @GetMapping("/profile/")
    public Object getCustomerProfile(HttpServletRequest http) {
        String autheader = http.getHeader("Authorization");

        if (autheader != null && autheader.startsWith("Bearer ")) {
            String token = autheader.substring(7);
            Claims claims = Jwts.parserBuilder()
                    .setSigningKey(jwtSecret)
                    .build()
                    .parseClaimsJws(token)
                    .getBody();

            if (claims.get("role").equals("admin")) {
                return "Access Granted";
            }
            else{
                return "invalid token";
            }
        }
        else {
            return "Invalid token";
        }
    }
    @GetMapping("/limited/")
    public String  protectDOSAttack(HttpServletRequest http){
     Bucket bucket=ratelimitservice.resolveBucket(http.getRemoteAddr());
     if(bucket.tryConsume(1)){
         return "Request Sucessfull";
     }
     else {
         return "Too many requests at a time please wait";
     }

    }
}
