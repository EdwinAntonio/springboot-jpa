package com.ingedwin.springboot.jpa.app.springboot_jpa.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "persons")
public class Person {
    private Long id;
    private String name;
    private String lastName;
    private String programmingLanguage;
}
