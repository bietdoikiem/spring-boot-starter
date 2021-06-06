package com.rmit.app.model;



import org.springframework.context.annotation.Configuration;

import javax.persistence.*;

@Entity
@Table(name="library")
public class Library {
    @Id
    @Column
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @Column
    private String subject;


    public Library() {
    }

    public Library(int id, String subject) {
        this.id = id;
        this.subject = subject;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}
