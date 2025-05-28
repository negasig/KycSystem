package com.example.kycsystem_demo.Model;

public class UserDTO {
    private String firstName;
    private String lastName;
    private String profession;
    private Integer age;
    private String gender;

    public long getNationalid() {
        return nationalid;
    }

    public void setNationalid(long nationalid) {
        this.nationalid = nationalid;
    }

    public long getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(long phonenumber) {
        this.phonenumber = phonenumber;
    }

    private long nationalid;
    private long phonenumber;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    private String email;
   public UserDTO(){}

    public UserDTO(String firstName, String lastName, String profession, Integer age, String gender, String email, long nationalid, long phonenumber ) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.profession = profession;
        this.age = age;
        this.gender = gender;
        this.email=email;
        this.nationalid=nationalid;
        this.phonenumber=phonenumber;
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
