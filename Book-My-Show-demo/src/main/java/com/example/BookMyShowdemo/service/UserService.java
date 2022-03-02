package com.example.BookMyShowdemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.example.BookMyShowdemo.dao.UserDao;
import com.example.BookMyShowdemo.entity.User;




@Service
public class UserService {
	
	@Lazy
	@Autowired
	UserDao userDao;
		
	public void registerForm(User user) {
		userDao.save(user);
	}
		
	public User findByUserName(String userName){
		return userDao.findByUserName(userName);
	}


}
