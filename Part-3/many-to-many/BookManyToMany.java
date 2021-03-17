package com.example.SpringJPAThree.manytomany;

import javax.persistence.*;
import java.util.Set;

@Entity
public class BookManyToMany {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    @ManyToMany(mappedBy = "books")
    Set<AuthorManyToMany> authors;

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

    public Set<AuthorManyToMany> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<AuthorManyToMany> authors) {
        this.authors = authors;
    }
}
