package com.example.SpringJPAThree;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class AuthorDaoService {
    @Autowired
    AuthorRepository authorRepository;

    public void addAuthorData() {

        Author author = new Author();
        author.setAuthorName("Dev");

        Address authorAddress = new Address();
        authorAddress.setStreetNumber(18);
        authorAddress.setLocation("India");
        authorAddress.setState("Mumbai");

        author.setAddress(authorAddress);

        Subject subject1 = new Subject();
        Subject subject2 = new Subject();
        Subject subject3 = new Subject();

        subject1.setSubjectName("Linux");
        subject2.setSubjectName("JVM");
        subject3.setSubjectName("Spring Boot");

        author.addSubject(subject1);
        author.addSubject(subject2);
        author.addSubject(subject3);
        System.out.println(author);
        authorRepository.save(author);
    }
}
