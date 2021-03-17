package com.example.SpringJPAThree.withoutadditionaltable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class AuthorWithoutAdditionalTableDaoService {
    @Autowired
    AuthorWithoutAdditionalTableRepository authorWithoutAdditionalTableRepository;

    public void addAuthorAndBook() {

        AuthorWithoutAdditionalTable author = new AuthorWithoutAdditionalTable();
        author.setAuthorName("James");

        BookWithoutAdditionalTable book1 = new BookWithoutAdditionalTable();
        BookWithoutAdditionalTable book2 = new BookWithoutAdditionalTable();
        BookWithoutAdditionalTable book3 = new BookWithoutAdditionalTable();

        book1.setBookName("Introduction to Operating System");
        book2.setBookName("Introduction to JPA with Hibernate");
        book3.setBookName("Introduction to Linux");

        author.addBook(book1);
        author.addBook(book2);
        author.addBook(book3);

        AuthorWithoutAdditionalTable author2 = new AuthorWithoutAdditionalTable();
        author2.setAuthorName("Charlie");

        BookWithoutAdditionalTable book11 = new BookWithoutAdditionalTable();
        BookWithoutAdditionalTable book12 = new BookWithoutAdditionalTable();
        BookWithoutAdditionalTable book13 = new BookWithoutAdditionalTable();

        book11.setBookName("Introduction to Java");
        book12.setBookName("Computer Networks");
        book13.setBookName("Introduction to Linux");

        author2.addBook(book11);
        author2.addBook(book12);
        author2.addBook(book13);

        authorWithoutAdditionalTableRepository.save(author);
        authorWithoutAdditionalTableRepository.save(author2);
    }
}
