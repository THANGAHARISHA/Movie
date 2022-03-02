package com.example.BookMyShowdemo.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.BookMyShowdemo.entity.Checkin;
import com.example.BookMyShowdemo.entity.Member;
import com.example.BookMyShowdemo.service.MemberService;


@RestController
public class CheckinRestController {
	
	@Autowired
	private MemberService memberService;
	
	
	@PostMapping("/checkin")
	public Member checkinFormSubmit(@RequestBody Member member) {
		Member memberFromDB= memberService.findById(member.getMemberId());
		Checkin checkinFromDB = memberFromDB.getCheckIn();
		checkinFromDB.setSeatNumber(member.getCheckIn().getSeatNumber());
		checkinFromDB.setTicketNumber("Ticket3");
		memberFromDB.setCheckIn(checkinFromDB);
        memberService.save(memberFromDB);
		return memberFromDB;
		
	}

}
