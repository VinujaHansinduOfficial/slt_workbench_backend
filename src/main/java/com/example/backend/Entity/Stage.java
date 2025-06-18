package com.example.backend.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "STAGE")
public class Stage {
    @Id
    private Long id;
    private String name;

    public Stage(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Stage() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

