package com.example.BookMyShowdemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.example.BookMyShowdemo.dao.TheatreInfoDao;
import com.example.BookMyShowdemo.entity.TheatreInfo;


@Service
public class TheatreInfoService {
	@Lazy
	@Autowired
	private TheatreInfoDao theatreInfoDao;
	

	public TheatreInfo findByNameOfTheatre(String name) {
		return theatreInfoDao.findByNameOfTheatre(name);
	}


}
