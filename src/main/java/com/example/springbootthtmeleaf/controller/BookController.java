package com.example.springbootthtmeleaf.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.springbootthtmeleaf.entity.Book;
import com.example.springbootthtmeleaf.entity.MyBookList;
import com.example.springbootthtmeleaf.service.BookService;
import com.example.springbootthtmeleaf.service.MyBookListService;


@Controller
public class BookController {
	
	@Autowired
	BookService bookservice;
	
	@Autowired
	MyBookListService mybookservice;
	
	@GetMapping("/")
	public String addBook() {
		return "home";
	}
	
	@GetMapping("/addBook")
	public String bookRegister(Model model) {
		model.addAttribute("book",new Book());
		return "bookRegister";
	}
	
	@GetMapping("/avaliablebook")
	public ModelAndView avaliableBook() {
		List<Book> booklist=bookservice.getallBook();
		
		return new ModelAndView("bookList","book",booklist);
	}
	
	@PostMapping("/save")
	public String saveBook(@ModelAttribute Book book) {
		bookservice.save(book);
		return "redirect:/avaliablebook";
	}

	@GetMapping("/mybook")
	public String myBook(Model model) {
		List<MyBookList> mybookList=mybookservice.getBookId();
		model.addAttribute("book", mybookList);
		return "mybook";
	}
	
	@RequestMapping("/mylist/{id}")
	public String getMylist(@PathVariable("id")int id) {
		Book b=bookservice.getBookById(id);
		MyBookList mb=new MyBookList(b.getId(),b.getName(),b.getAuthor(),b.getPrice());
		mybookservice.saveBooks(mb);
		return "redirect:/mybook";
	}
	
	@RequestMapping("/editBook/{id}")
	public String editBook(@PathVariable("id")int id,Model model) {
		Book b=bookservice.getBookById(id);
		model.addAttribute("book",b);
		return "bookEdit";
	}
	
	@RequestMapping("/deleteBook/{id}")
	public String deleteBook(@PathVariable("id")int id ) {
		bookservice.deleteBook(id);
		return "redirect:/avaliablebook";
	}
}
