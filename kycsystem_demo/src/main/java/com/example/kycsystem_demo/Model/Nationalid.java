package com.example.kycsystem_demo.Model;

import jakarta.persistence.*;

@Entity
@Table
public class Nationalid {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id

    private Integer id;
    private long fiydaNumber;
    private String firstName;

    public long getFiydaNumber() {
        return fiydaNumber;
    }

    public void setFiydaNumber(long fiydaNumber) {
        this.fiydaNumber = fiydaNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
}
