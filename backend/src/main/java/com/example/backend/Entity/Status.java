package com.example.backend.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "STATUS")
public class Status {
    @Id
    private Integer id;
    private String name;

    public Status(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Status() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}