package com.example.kycsystem_demo.Model;

public class UserDTO {
    private String firstName;
    private String lastName;
    private String profession;
    private Integer age;
    private String gender;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    private String email;
   public UserDTO(){}

    public UserDTO(String firstName, String lastName, String profession, Integer age, String gender, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.profession = profession;
        this.age = age;
        this.gender = gender;
        this.email=email;
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
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
