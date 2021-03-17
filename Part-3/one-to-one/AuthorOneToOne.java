package com.example.SpringJPAThree.onetone;


import com.example.SpringJPAThree.Address;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class AuthorOneToOne {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int authorId;
    private String authorName;

    @Embedded
    Address address;

    @OneToOne(mappedBy = "author", cascade = CascadeType.ALL)
    BookOneToOne book;

    public BookOneToOne getBook() {
        return book;
    }

    public void setBook(BookOneToOne book) {
        this.book = book;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
