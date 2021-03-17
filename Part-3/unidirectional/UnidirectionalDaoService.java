package com.example.SpringJPAThree.unidirectional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class UnidirectionalDaoService {

    @Autowired
    UnidirectionalRepository unidirectionalRepository;

    public void addAuthorBookUnidirectionally() {

        UnidirectionalAuthor author = new UnidirectionalAuthor();
        author.setAuthorName("James");

        UnidirectionalBook book1 = new UnidirectionalBook();
        UnidirectionalBook book2 = new UnidirectionalBook();
        UnidirectionalBook book3 = new UnidirectionalBook();

        book1.setBookName("Introduction to Operating System");
        book2.setBookName("Introduction to JPA with Hibernate");
        book3.setBookName("Introduction to Linux");

        author.addBook(book1);
        author.addBook(book2);
        author.addBook(book3);

        UnidirectionalAuthor author2 = new UnidirectionalAuthor();
        author2.setAuthorName("Charlie");

        UnidirectionalBook book11 = new UnidirectionalBook();
        UnidirectionalBook book12 = new UnidirectionalBook();
        UnidirectionalBook book13 = new UnidirectionalBook();

        book11.setBookName("Introduction to Java");
        book12.setBookName("Computer Networks");
        book13.setBookName("Introduction to Linux");

        author2.addBook(book11);
        author2.addBook(book12);
        author2.addBook(book13);

        unidirectionalRepository.save(author);
        unidirectionalRepository.save(author2);
    }
}
