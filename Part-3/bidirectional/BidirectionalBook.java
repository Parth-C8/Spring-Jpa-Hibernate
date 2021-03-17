package com.example.SpringJPAThree.bidirectional;

import javax.persistence.*;

@Entity
@Table(name = "book_bidirectional")
public class BidirectionalBook {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bookId;
    private String bookName;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private BidirectionalAuthor author;

    public BidirectionalAuthor getAuthor() {
        return author;
    }

    public void setAuthor(BidirectionalAuthor author) {
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
