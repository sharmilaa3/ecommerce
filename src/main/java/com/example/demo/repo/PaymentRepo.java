package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.modal.Payment;



public interface PaymentRepo extends JpaRepository<Payment, Integer>{

}
