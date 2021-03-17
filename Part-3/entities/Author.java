package com.example.SpringJPAThree;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "author")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int authorId;
    private String authorName;

    @Embedded
    Address address;

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
    private Set<Subject> subjects;


    public Set<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(Set<Subject> subjects) {
        this.subjects = subjects;
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

    public void addSubject(Subject subject){
        if (subject != null){
            if (subjects == null){
                subjects = new HashSet<Subject>();
            }
            subject.setAuthor(this);
            subjects.add(subject);
        }
    }
}
