package com.example.SpringJPAThree.onetone;

import com.example.SpringJPAThree.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class OneToOneDaoService {
    @Autowired
    OneToOneRepository oneToOneRepository;

    public void addOneToOneAuthorBook(){

        AuthorOneToOne authorOneToOne = new AuthorOneToOne();
        authorOneToOne.setAuthorName("R.D.Sharma");

        Address authorAddress = new Address();
        authorAddress.setStreetNumber(20);
        authorAddress.setLocation("Mumbai");
        authorAddress.setState("Maharashtra");

        authorOneToOne.setAddress(authorAddress);

        BookOneToOne book = new BookOneToOne();
        book.setBookName("Trigonometry");
        book.setAuthor(authorOneToOne);
        authorOneToOne.setBook(book);

        oneToOneRepository.save(authorOneToOne);
    }
}
