package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.modal.Admin;



public interface AdminRepo extends JpaRepository<Admin, Integer>{

}
