package com.crud.example.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.crud.example.entity.Hotel;
import com.crud.example.service.HotelManagementService;


@RestController //@Controller
//@RequestMapping("/test")
public class HotelManagementSystemController {
	
	Logger logger = LoggerFactory.getLogger(HotelManagementSystemController.class);

	@Autowired
	private HotelManagementService hotelManagementSystemService;

	@PostMapping("/addBooking") //endpoint/api/service
	public Hotel addBooking(@RequestBody Hotel hotel) {
		return hotelManagementSystemService.saveBooking(hotel);
	}
	
	

	@PostMapping("/addBookings")
	public List<Hotel> addBookings(@RequestBody List<Hotel> hotel) {
		try {
		return hotelManagementSystemService.saveBookings(hotel);
		}finally {
			System.out.println("Got Result");
		}
	}

	@GetMapping("/Bookings")
	public List<Hotel> findAllBookings() {
		logger.trace("Accessed the Booking List");
		return hotelManagementSystemService.getBookings();
	}

	@GetMapping("/BookingById/{id}")  // srvice name
	public Hotel findBookingById(@PathVariable int id) {  // request parameter
		return hotelManagementSystemService.getBookingById(id);
	}

	@GetMapping("/hotel/{name}")
	public Hotel findBookingByName(@PathVariable String name) {
		return hotelManagementSystemService.getBookingByName(name);
	}

	@PutMapping("/update")
	public Hotel updateBooking(@RequestBody Hotel hotel) {
		return hotelManagementSystemService.updateBooking(hotel);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteBooking(@PathVariable int id) {
		return hotelManagementSystemService.deleteBooking(id);
	}
//7 services
}
