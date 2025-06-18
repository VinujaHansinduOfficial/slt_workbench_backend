package com.example.backend.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "USER")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer serviceNo;
    private String name;
    private String email;
    private String priRole;
    private String password;
    private String designation;
    private String section;
    @Column(name = "user_group") // Avoids using the reserved keyword
    private String group;

    public User(Integer serviceNo, String name, String email, String priRole, String password, String designation, String section, String group) {
        this.serviceNo = serviceNo;
        this.name = name;
        this.email = email;
        this.priRole = priRole;
        this.password = password;
        this.designation = designation;
        this.section = section;
        this.group = group;
    }

    public User() {
    }

    public Integer getServiceNo() {
        return serviceNo;
    }

    public void setServiceNo(Integer serviceNo) {
        this.serviceNo = serviceNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPriRole() {
        return priRole;
    }

    public void setPriRole(String priRole) {
        this.priRole = priRole;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }
}