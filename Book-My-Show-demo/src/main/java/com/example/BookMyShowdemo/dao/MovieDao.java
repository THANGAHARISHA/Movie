package com.example.BookMyShowdemo.dao;


import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.BookMyShowdemo.entity.Movie;

@Repository
public interface MovieDao extends JpaRepository<Movie, Integer>  {
	
	@EntityGraph(attributePaths = { "amount", "movieInfo", "inventory", "movieInfo.theatreInfo" })
	List<Movie> findByMovieInfoTheatreInfoNameOfTheatreAndMovieDate(String name, LocalDate movieDate);

	@EntityGraph(attributePaths = { "amount", "movieInfo", "inventory", "movieInfo.theatreInfo" })
	List<Movie> findByPlaceAndMovieDate(String place, LocalDate movieDate);

	@EntityGraph(attributePaths = { "amount", "movieInfo", "inventory", "movieInfo.theatreInfo" })
	List<Movie> getMoviesByPlaceAndMovieNameAndMovieDateOrderByAmountAmount(String place, String movieName,
			LocalDate movieDate);

	@EntityGraph(attributePaths = { "amount", "movieInfo", "inventory", "movieInfo.theatreInfo" })
	@Query(value = "from Movie m where m.place= :place and m.movieName= :movieName and m.movieDate= :movieDate and m.inventory.count >= :count order by m.amount.amount")
	List<Movie> getMoviesByPlaceAndMovieNameAndMovieDateOrderByAmountAmount(String place, String movieName,
			LocalDate movieDate, int count);

	@EntityGraph(attributePaths = { "amount","movieInfo", "inventory", "movieInfo.theatreInfo" })
	List<Movie> findByMovieNumberAndPlaceAndMovieName(String movieNumber, String place, String movieName);

	@EntityGraph(attributePaths = { "amount", "movieInfo", "inventory", "movieInfo.theatreInfo" })
	Movie findByMovieNumberAndMovieDateAndMovieTime(String movieNumber, LocalDate movieDate,
			LocalTime movieTime);

	@EntityGraph(attributePaths = { "amount", "movieInfo", "inventory", "movieInfo.theatreInfo" })
	Movie findByPlaceAndMovieNameAndMovieDateAndMovieTime(String place, String movieName, LocalDate movieDate,
			LocalTime movieTime);
	

}
