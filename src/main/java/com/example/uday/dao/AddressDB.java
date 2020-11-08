package com.example.uday.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.uday.pojo.Address;

@Repository
public interface AddressDB extends JpaRepository<Address, Integer>{
	List<Address> findByUserEmailId(String userEmailId);
}
