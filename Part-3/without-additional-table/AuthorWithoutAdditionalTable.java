package com.example.SpringJPAThree.withoutadditionaltable;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class AuthorWithoutAdditionalTable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int authorId;
    private String authorName;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "author_id")
    private Set<BookWithoutAdditionalTable> books;

    public Set<BookWithoutAdditionalTable> getBooks() {
        return books;
    }

    public void setBooks(Set<BookWithoutAdditionalTable> books) {
        this.books = books;
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

    public void addBook(BookWithoutAdditionalTable book){
        if (book != null){
            if (books == null){
                books = new HashSet<BookWithoutAdditionalTable>();
            }
            books.add(book);
        }
    }
}
