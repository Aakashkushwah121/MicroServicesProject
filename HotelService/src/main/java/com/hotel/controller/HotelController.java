package com.hotel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.entities.Hotel;
import com.hotel.service.HotelService;

@RestController
@RequestMapping("/hotels")
public class HotelController {

	@Autowired
	private HotelService hotelservice;
	
	@PostMapping
	public ResponseEntity<Hotel> create(@RequestBody Hotel hotel)
	{
//		Hotel hotel1= hotelservice.create(hotel);
//		return ResponseEntity.status(HttpStatus.CREATED).body(hotel1);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(hotelservice.create(hotel));
	}
	
	@GetMapping
	public ResponseEntity<List<Hotel>> getAllHotels()
	{
		List<Hotel> allHotel= hotelservice.getAllHotels();
		return ResponseEntity.ok(allHotel);
	}
	
	@GetMapping("/{hotelId}")
	public ResponseEntity<Hotel> getHotelById(@PathVariable String hotelId)
	{
		Hotel hotel= hotelservice.getSingleHotel(hotelId);
		return ResponseEntity.ok(hotel);
	}
}
