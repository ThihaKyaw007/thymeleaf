package com.example.springbootthtmeleaf.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springbootthtmeleaf.entity.MyBookList;

@Repository
public interface MyBookListRepo extends JpaRepository<MyBookList, Integer> {

}
