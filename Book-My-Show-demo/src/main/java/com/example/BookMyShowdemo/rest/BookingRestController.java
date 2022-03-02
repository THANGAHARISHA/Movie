package com.example.BookMyShowdemo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.BookMyShowdemo.entity.BookingRecord;
import com.example.BookMyShowdemo.service.BookingService;


@RestController
public class BookingRestController {
	
	@Autowired
	private BookingService bookingService;
	
	
	@GetMapping("/allBookings")
	public List<BookingRecord> findAll(){
		return bookingService.findAll();
	}
	
	@PostMapping("/bookMovie")
	public BookingRecord bookMovie(@RequestBody BookingRecord bookingRecord) {	
		return bookingService.bookMovie(bookingRecord);
	}
	
	@GetMapping("/booking/{id}")
	public  BookingRecord getBookingById(@PathVariable int id) {
		System.out.println("id"+id);
		return bookingService.getBookingById(id);
	}
	
	

}
