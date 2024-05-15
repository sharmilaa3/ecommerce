package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.modal.Address;

public interface AddressRepo extends JpaRepository<Address, Integer>{ 
	

}
