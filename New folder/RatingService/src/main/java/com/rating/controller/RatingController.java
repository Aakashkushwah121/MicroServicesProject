package com.rating.controller;

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

import com.rating.entities.Rating;
import com.rating.impl.RatingServiceImpl;
import com.rating.service.RatingService;

@RestController
@RequestMapping("/rating")
public class RatingController {

	@Autowired
	private RatingServiceImpl ratingservice;
	
	@PostMapping
	public ResponseEntity<Rating> create(@RequestBody Rating rating)
	{
//		Rating rating1= ratingservice.create(rating);
//		return ResponseEntity.status(HttpStatus.CREATED).body(rating1);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(ratingservice.create(rating));
	}
	
	@GetMapping
	public ResponseEntity<List<Rating>> getAllRating()
	{
		return ResponseEntity.ok(ratingservice.getAll());
	}
	
	@GetMapping("/user/{userId}")
	public ResponseEntity<List<Rating>> getRatingBtUserId(@PathVariable String userId)
	{
		return ResponseEntity.ok(ratingservice.getRatingByUserId(userId));
	}
	
	@GetMapping("/hotel/{hotelId}")
	public ResponseEntity<List<Rating>> getRatingByHotelId(@PathVariable String hotelId)
	{
		return ResponseEntity.status(HttpStatus.OK).body(ratingservice.getRatingByHotelId(hotelId));
	}
	
}
