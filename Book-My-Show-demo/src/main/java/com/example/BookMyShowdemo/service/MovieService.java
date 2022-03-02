package com.example.BookMyShowdemo.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.example.BookMyShowdemo.dao.MovieDao;
import com.example.BookMyShowdemo.entity.Movie;


@Service
public class MovieService {
	
	@Lazy
	@Autowired
	private MovieDao movieDao;

	public List<Movie> findByMovieInfoTheatreInfoNameOfTheatreAndMovieDate(String name, LocalDate movieDate) {
		return movieDao.findByMovieInfoTheatreInfoNameOfTheatreAndMovieDate(name, movieDate);
	}

	public List<Movie> findByPlaceAndMovieDate(String place, LocalDate movieDate) {
		return movieDao.findByPlaceAndMovieDate(place, movieDate);
	}

	public List<Movie> getMovieByPlaceAndMovieNameAndMovieDateOrderByAmountAmount(String place, String movieName,
			LocalDate movieDate) {
		return movieDao.getMoviesByPlaceAndMovieNameAndMovieDateOrderByAmountAmount( place, movieName, movieDate);
	}

	public List<Movie> getMoviesByPlaceAndMovieNameAndMovieDateOrderByAmountAmount(String place, String movieName,
			LocalDate movieDate, int numberOfMember) {
		return movieDao.getMoviesByPlaceAndMovieNameAndMovieDateOrderByAmountAmount(place, movieName, movieDate,
				numberOfMember);
	}

	public List<Movie> findByMovieNumberAndPlaceAndMovieName(String movieNumber, String place,
			String movieName) {
		return movieDao.findByMovieNumberAndPlaceAndMovieName(movieNumber, place, movieName);
	}

	public Movie findByMovieNumberAndMovieDateAndMovieTime(String movieNumber, LocalDate movieDate,
			LocalTime movieTime) {
		return movieDao.findByMovieNumberAndMovieDateAndMovieTime(movieNumber, movieDate, movieTime);
	}
	
	public List<Movie> saveAll(List<Movie> movies) {
		return movieDao.saveAll(movies);
	}

	public Movie saveMovie(Movie movie) {
		return movieDao.save(movie);
	}

	public Movie findByPlaceAndMovieNameAndMovieDateAndMovieTime(String place, String movieName,
			LocalDate movieDate, LocalTime movieTime) {
		return movieDao.findByPlaceAndMovieNameAndMovieDateAndMovieTime(place,movieName, movieDate,
				movieTime);
	}
	
	public List<Movie> findAll(){
		return movieDao.findAll();
	}


}
