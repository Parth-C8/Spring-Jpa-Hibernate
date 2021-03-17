package com.example.SpringJPAThree.unidirectional;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class UnidirectionalAuthor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int authorId;
    private String authorName;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "author_id")
    private Set<UnidirectionalBook> books;

    public Set<UnidirectionalBook> getBooks() {
        return books;
    }

    public void setBooks(Set<UnidirectionalBook> books) {
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

    public void addBook(UnidirectionalBook book){
        if (book != null){
            if (books == null){
                books = new HashSet<UnidirectionalBook>();
            }
            books.add(book);
        }
    }
}
