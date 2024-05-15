package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.modal.PaymentModal;



public interface PaymentMoRepo extends JpaRepository<PaymentModal, Integer>{

}
