package com.example.BookMyShowdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.example.BookMyShowdemo.dao.MemberDao;
import com.example.BookMyShowdemo.entity.Member;


@Service
public class MemberService {
	@Lazy
	@Autowired
	private MemberDao memberDao;
	
	public List<Member> getAllMembers() {
		return memberDao.findAll();
	}
	
	
	public Member findById(int id) {
		return memberDao.findById(id).get();
	}
	
	public void saveAll(List<Member> members) {
		memberDao.saveAll(members);
	}
	
	public void save(Member member) {
		memberDao.save(member);
	}

}
