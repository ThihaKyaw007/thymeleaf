package com.example.springbootthtmeleaf.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springbootthtmeleaf.entity.MyBookList;
import com.example.springbootthtmeleaf.repository.MyBookListRepo;

@Service
public class MyBookListService {

	@Autowired
	private MyBookListRepo mybookrepo;
	
	public void saveBooks(MyBookList mybooklist) {
		
		mybookrepo.save(mybooklist);
		
	}
	
	
	public List<MyBookList> getBookId() {
		
		return mybookrepo.findAll();
		
	}
}
