package com.example.BookMyShowdemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.BookMyShowdemo.entity.Member;

@Repository
public interface MemberDao extends JpaRepository<Member, Integer>  {

}
