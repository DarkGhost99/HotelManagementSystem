package com.crud.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.crud.example.entity.Hotel;
import com.crud.example.repository.HotelManagementRepository;
import com.crud.example.service.HotelManagementService;

@SpringBootTest
class SampleSpringBootProjectApplicationTests {

	@Autowired
	private HotelManagementService service;
	
	@MockBean
	private HotelManagementRepository repository;
	
	@Test
	public void getProducts() {
		
		when(repository.findAll()).thenReturn(Stream
				.of(new Hotel(1,"Test",1,100.0),new Hotel(2,"test2",4,500.00)).collect(Collectors.toList()));
		assertEquals(2, service.getBookings().size());
	}
	
	@Test
	public void saveProducts() {
		Hotel product = new Hotel(1,"Mobile",1,100.0);
		when(repository.save(product)).thenReturn(product);
		assertEquals(product, service.saveBooking(product));
	}
}
