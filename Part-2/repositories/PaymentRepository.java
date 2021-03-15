package com.example.SpringJPATwo.repository;

import com.example.SpringJPATwo.InheritanceMapping.Payment;
import org.springframework.data.repository.CrudRepository;

public interface PaymentRepository extends CrudRepository<Payment, Integer> {
}
