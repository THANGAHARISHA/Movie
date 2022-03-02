package com.example.BookMyShowdemo.rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {
	
	@GetMapping("/")
	public String homepage() {
		return "view/searchMovies";
	}

	@GetMapping("/login")
	public String login() {
		return "view/login";
	}
	
	@GetMapping("/register")
	public String register() {
		return "view/register";
	}
	
	@GetMapping("/bookMovie")
	public String bookMovie() {
		return "view/bookMovie";
	}
	

	@GetMapping("/checkin")
	public String checkinPage() {
		return "view/checkin";
		
	}

}
