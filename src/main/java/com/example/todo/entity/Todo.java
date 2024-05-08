package com.example.todo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "todos")
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "title")
    private String title;
    @Column(name = "description")
    private String description;
    @Column(name = "isActive")
    private boolean isActive;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
