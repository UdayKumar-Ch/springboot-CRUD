package com.example.uday.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.example.uday.dao.pojo.Address;

@Repository
public interface AddressDB extends JpaRepository<Address, Long>{
	
	@Query(value = "select a.address_id, a.line1, a.line2, a.line3, a.city, a.postal_code, a.country, a.state, a.email_id  from address a where a.email_id = ?1", nativeQuery = true)
	List<Address> findByAddressEmailId(String userEmailId);
}
