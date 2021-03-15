package com.example.SpringJPATwo.InheritanceMapping;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "card")
//@DiscriminatorValue(value = "cc")
@PrimaryKeyJoinColumn(name = "id")
public class CreditCard extends Payment {

    private String cardnumber;

    public String getCardnumber() {
        return cardnumber;
    }

    public void setCardnumber(String cardnumber) {
        this.cardnumber = cardnumber;
    }
}



