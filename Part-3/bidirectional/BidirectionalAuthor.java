package com.example.SpringJPAThree.bidirectional;


import com.example.SpringJPAThree.Address;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "author_bidirectional")
public class BidirectionalAuthor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int authorId;
    private String authorName;

    @Embedded
    Address address;

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
    private Set<BidirectionalBook> bidirectionalBooks;

    public Set<BidirectionalBook> getBidirectionalBooks() {
        return bidirectionalBooks;
    }

    public void setBidirectionalBooks(Set<BidirectionalBook> bidirectionalBooks) {
        this.bidirectionalBooks = bidirectionalBooks;
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

    public void addBook(BidirectionalBook book){
        if (book != null){
            if (bidirectionalBooks == null){
                bidirectionalBooks = new HashSet<BidirectionalBook>();
            }
            book.setAuthor(this);
            bidirectionalBooks.add(book);
        }
    }
}
