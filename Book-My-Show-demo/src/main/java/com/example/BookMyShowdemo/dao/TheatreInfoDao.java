package com.example.BookMyShowdemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.BookMyShowdemo.entity.TheatreInfo;

@Repository
public interface TheatreInfoDao extends JpaRepository<TheatreInfo, Integer> {
	
	TheatreInfo findByNameOfTheatre(String name); 

}
