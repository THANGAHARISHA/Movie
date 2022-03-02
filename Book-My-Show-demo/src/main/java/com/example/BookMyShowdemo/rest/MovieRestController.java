package com.example.BookMyShowdemo.rest;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.BookMyShowdemo.entity.Movie;
import com.example.BookMyShowdemo.service.MovieService;
import com.example.BookMyShowdemo.vo.SearchCriteria;

@RestController

public class MovieRestController {
	@Autowired
	private MovieService movieService;

	@RequestMapping(value = "/searchMovies", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public List<Movie> searchMovies(@RequestBody SearchCriteria searchcriteria) {
		LocalDate movieDate = Instant.ofEpochMilli(searchcriteria.getMovieDate().getTime())
				.atZone(ZoneId.systemDefault()).toLocalDate();
		List<Movie> movies = movieService.getMoviesByPlaceAndMovieNameAndMovieDateOrderByAmountAmount(
				searchcriteria.getPlace(), searchcriteria.getMovieName(), movieDate, searchcriteria.getCount());
		return movies;
	}

	@RequestMapping(value = "/getMovieByNumberMovieDateMovieTime", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public Movie getMovieByNumberMovieDateMovieTime(@RequestBody Movie movie) {
		System.out.println(movie.getMovieNumber());
		System.out.println(movie.getMovieDate());
		System.out.println(movie.getMovieTime());
		return movieService.findByMovieNumberAndMovieDateAndMovieTime(movie.getMovieNumber(),
				movie.getMovieDate(), movie.getMovieTime());
	}
}
