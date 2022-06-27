package com.crud.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.example.entity.Hotel;
import com.crud.example.repository.HotelManagementRepository;

@Service
public class HotelManagementService {

	@Autowired
	private HotelManagementRepository hotelManagementRepository;
	

	public Hotel saveBooking(Hotel hotel) {
		
				//logic
		return hotelManagementRepository.save(hotel);
				
	}
	
	public List<Hotel> saveBookings(List<Hotel> hotel) {

		return hotelManagementRepository.saveAll(hotel);
	}

	public List<Hotel> getBookings() {
		return hotelManagementRepository.findAll();
	}

	public Hotel getBookingById(int id) {  // user story -- BA, User Story,lead, Technical software, tools, DB(Sample), AWS
		
		if(id<9) { // here code logic // businees requirement impl // sql -- Product, Customer, Dept, --pojo - bean --Relation btw tables--
			// BUsinees logic logic -- passing to DB -- After getting data then how you want view to UI
			return hotelManagementRepository.findById(id).orElse(null);
		}

		return hotelManagementRepository.findById(id).orElse(null);
	}

	public Hotel getBookingByName(String name) {

		return hotelManagementRepository.findByName(name);
	}

	public String deleteBooking(int id) {
		hotelManagementRepository.deleteById(id);
		return "Booking removed !!" + id;
	}

	public Hotel updateBooking(Hotel hotel) {

		Hotel existingBooking = hotelManagementRepository.findById(hotel.getId()).orElse(null);
		existingBooking.setName(hotel.getName());
		existingBooking.setQuantity(hotel.getQuantity());
		existingBooking.setPrice(hotel.getPrice());
		return hotelManagementRepository.save(existingBooking);
	}

}
