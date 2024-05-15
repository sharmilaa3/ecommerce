package com.example.demo.repo;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.modal.User;

public interface UserRepo extends JpaRepository<User, Integer>{

}
