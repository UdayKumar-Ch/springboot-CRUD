package com.example.uday.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.uday.pojo.UserInformation;

@Repository
public interface UserInformationDB extends JpaRepository<UserInformation, String>{

	
}

