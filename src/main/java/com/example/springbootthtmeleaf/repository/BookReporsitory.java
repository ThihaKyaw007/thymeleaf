package com.example.springbootthtmeleaf.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springbootthtmeleaf.entity.Book;

@Repository
public interface BookReporsitory extends JpaRepository<Book,Integer>{

}
