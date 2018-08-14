package com.kg.springboot.repository;


import com.kg.springboot.controller.BookController;
import com.kg.springboot.model.BookCategory;

import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<BookCategory, Serializable> {

	BookController saveAndFlush(BookController firstEvent);

}