package com.example.SpringJPAThree.manytomany;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.awt.print.Book;
import java.util.HashSet;

@Service
public class ManyToManyDaoService {
    @Autowired
    ManyToManyRepository manyToManyRepository;

    public void addManyToManyAuthorBook(){
        AuthorManyToMany authorManyToMany = new AuthorManyToMany();
        authorManyToMany.setName("Clark");

        BookManyToMany book = new BookManyToMany();
        book.setName("Java Programming");
        BookManyToMany book1 = new BookManyToMany();
        book1.setName("Spring Boot");

        authorManyToMany.addBook(book);
        authorManyToMany.addBook(book1);

        manyToManyRepository.save(authorManyToMany);
    }
}
