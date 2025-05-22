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
}
