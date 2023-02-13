package com.hotel.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.entities.Hotel;
import com.hotel.exception.ResourceNotFound;
import com.hotel.repository.HotelRepository;
import com.hotel.service.HotelService;

@Service
public class HotelServiceImpl implements HotelService{

	@Autowired
	private HotelRepository hotelrepository;
	
	@Override
	public Hotel create(Hotel hotel) {
		// TODO Auto-generated method stub
		String randomId=UUID.randomUUID().toString();
		hotel.setHotelId(randomId);
		return hotelrepository.save(hotel);
	}

	@Override
	public List<Hotel> getAllHotels() {
		// TODO Auto-generated method stub
		return hotelrepository.findAll();
	}

	@Override
	public Hotel getSingleHotel(String hotelId) {
		// TODO Auto-generated method stub
		return hotelrepository.findById(hotelId).orElseThrow(()-> new ResourceNotFound("id not exit on server"+hotelId));
	}

	
}
