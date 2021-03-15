package com.example.SpringJPATwo.InheritanceMapping;

import com.example.SpringJPATwo.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentDaoService {

    @Autowired
    PaymentRepository paymentRepository;

    public void createCardPayment()
    {
        CreditCard card1 = new CreditCard();
        card1.setId(501);
        card1.setAmount(1500);
        card1.setCardnumber("cc123");
        paymentRepository.save(card1);

        CreditCard card2 = new CreditCard();
        card2.setId(502);
        card2.setAmount(1700);
        card2.setCardnumber("cc124");
        paymentRepository.save(card2);

        CreditCard card3 = new CreditCard();
        card3.setId(503);
        card3.setAmount(1800);
        card3.setCardnumber("cc12345");
        paymentRepository.save(card3);
    }

    public void createCheckPayment()
    {
        Check check1 = new Check();
        check1.setId(701);
        check1.setAmount(1500);
        check1.setChecknumber("ch1002");
        paymentRepository.save(check1);

        Check check2 = new Check();
        check2.setId(702);
        check2.setAmount(1700);
        check2.setChecknumber("ch1003");
        paymentRepository.save(check2);

        Check check3 = new Check();
        check3.setId(703);
        check3.setAmount(1800);
        check3.setChecknumber("ch1005");
        paymentRepository.save(check3);
    }

}
