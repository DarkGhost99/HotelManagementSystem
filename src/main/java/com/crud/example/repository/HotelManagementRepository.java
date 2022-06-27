package com.crud.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crud.example.entity.Hotel;

public interface HotelManagementRepository extends JpaRepository<Hotel,Integer> {
		Hotel findByName(String name); //custom method
			
}
//CRUDRepository