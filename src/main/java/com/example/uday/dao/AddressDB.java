package com.example.uday.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.uday.pojo.Address;

@Repository
public interface AddressDB extends JpaRepository<Address, Long>{
	
	@Query(value = "select a from address a where email_id = ?1", nativeQuery = true)
	List<Address> findByAddressEmailId(String userEmailId);
}
