package com.example.springbootthtmeleaf.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springbootthtmeleaf.entity.Book;
import com.example.springbootthtmeleaf.repository.BookReporsitory;

@Service
public class BookService {
	
	@Autowired
	private BookReporsitory bookRepo;
	
	public void save(Book book) {
		bookRepo.save(book);
	}
	
	public List<Book> getallBook(){
		return bookRepo.findAll();
	}
	
	public Book getBookById(int id) {
		return bookRepo.findById(id).get();
		
	}
	
	public void deleteBook(int id) {
		bookRepo.deleteById(id);
	}

}
