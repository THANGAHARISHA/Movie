package com.example.BookMyShowdemo.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.example.BookMyShowdemo.dao.BookingDao;
import com.example.BookMyShowdemo.entity.BookingRecord;
import com.example.BookMyShowdemo.entity.Checkin;
import com.example.BookMyShowdemo.entity.Member;
import com.example.BookMyShowdemo.entity.Movie;
import com.example.BookMyShowdemo.entity.User;




@Service
public class BookingService {
	

	@Lazy
	@Autowired
	private BookingDao bookingDao;

	@Lazy
	@Autowired
	private MemberService memberService;

	@Lazy
	@Autowired
	private MovieService movieService;

	@Lazy
	@Autowired
	private UserService userService;

	public List<BookingRecord> findAll() {
		return bookingDao.findAll();
	}

	
	@Transactional
	public BookingRecord bookMovie(BookingRecord record) {

		List<Member>  membersList = new ArrayList<>();

		record.getMembers().forEach(member-> {
			if (!StringUtils.isEmpty(member.getFirstName()) && !StringUtils.isEmpty(member.getLastName())
					&& !StringUtils.isEmpty(member.getGender())
					&& !StringUtils.isEmpty(member.getMobileNumber())) {
				membersList.add(member);
				//	customer.setBookingId(bookingRecordFromDB.getBookingId());
				//	customerService.save(customer);
			}
		});

		BookingRecord bookingRecord = new BookingRecord(LocalDateTime.now(), record.getMovieName(), record.getAmount(),
				record.getMovieDate(), record.getMovieNumber(), record.getMovieTime(), record.getPlace(), "Booked",
				membersList);
		BookingRecord bookingRecordFromDB = bookingDao.save(bookingRecord);
		membersList.forEach(member -> {
			member.setBookingId(bookingRecordFromDB.getBookingId());
			member.setCheckIn(new Checkin(null, null));
        	   memberService.save(member);
		});

		

         Movie movie = movieService.findByMovieNumberAndMovieDateAndMovieTime(record.getMovieNumber(),
				record.getMovieDate(), record.getMovieTime());
		int count = movie.getInventory().getCount();
	movie.getInventory().setCount(count - record.getMembers().size());
		movieService.saveMovie(movie);
		return bookingRecord;
	}

	public List<BookingRecord> findBookingRecordByUserId(String userName) {
		User user = userService.findByUserName(userName);
		System.out.println(user.getId());
		return bookingDao.getBookingRecordsByUserId(user.getId());
	}

	public BookingRecord getBookingById(int bookingId) {
		return bookingDao.findByBookingId(bookingId);
	}


}
