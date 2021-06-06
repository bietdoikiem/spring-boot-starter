package com.rmit.app.model;


import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="author")
public class Author {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String name;

    @Column
    private String academicCredentials;

    @OneToMany(mappedBy = "author", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<Book> bookList;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="library_id", referencedColumnName = "id")
    private Library library;


    public Author() {
    }

    public Author(int id, String name, String academicCredentials) {
        this.id = id;
        this.name = name;
        this.academicCredentials = academicCredentials;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAcademicCredentials() {
        return academicCredentials;
    }

    public void setAcademicCredentials(String academicCredentials) {
        this.academicCredentials = academicCredentials;
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }
}
