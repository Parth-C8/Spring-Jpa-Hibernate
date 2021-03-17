package com.example.SpringJPAThree.onetone;

import javax.persistence.*;

@Entity
public class BookOneToOne {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bookId;
    private String bookName;

    @OneToOne
    @JoinColumn(name = "author_id")
    private AuthorOneToOne author;

    public AuthorOneToOne getAuthor() {
        return author;
    }

    public void setAuthor(AuthorOneToOne author) {
        this.author = author;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }
}

