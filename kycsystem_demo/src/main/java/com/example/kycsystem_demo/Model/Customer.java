package com.example.kycsystem_demo.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.id.factory.internal.AutoGenerationTypeStrategy;

@Entity
@Table
@Data
public class Customer {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id

    private Integer id;
    @NotNull(message = "First name is required")
    private String firstName;
    @NotEmpty(message = "last name is required")
    private String lastName;
    private String Profession;
    private Long nationalId;

    public Long getNationalId() {
        return nationalId;
    }

    public void setNationalId(Long nationalId) {
        this.nationalId = nationalId;
    }

    private  String username;
    private String password;
    private int Age;
    private double Salary;
    private String Email;
    private String Gender;
    private String role;

    public Integer getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getProfession() {
        return Profession;
    }

    public void setProfession(String profession) {
        Profession = profession;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        Age = age;
    }

    public double getSalary() {
        return Salary;
    }

    public void setSalary(double salary) {
        Salary = salary;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }
}
