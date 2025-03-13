package com.movie.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.movie.model.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {

}
