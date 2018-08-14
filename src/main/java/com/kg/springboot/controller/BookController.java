package com.kg.springboot.controller;

import com.kg.springboot.model.BookCategory;
import com.kg.springboot.repository.BookRepository;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController

@RequestMapping(value="/books")

/**
 * BookController
 */
public class BookController {

    @Autowired
   private BookRepository bookRepository;


    @RequestMapping(method=RequestMethod.GET)

     public Iterable<BookCategory> read() {
       return bookRepository.findAll();
     }

     @RequestMapping(value="/{bookid}", method = RequestMethod.GET)

      public Optional<BookCategory> readOne(@RequestParam Long bookcatId) {
       System.out.println(bookRepository.findById(bookcatId));
       return bookRepository.findById(bookcatId);
      }

      @RequestMapping(method = RequestMethod.POST)
  public BookCategory add(@RequestBody BookCategory book) {
      book.setBookcatId(null);
      return bookRepository.saveAndFlush(book);
  }

  @RequestMapping(value="/{id}",method=RequestMethod.PUT)
   public BookCategory update(@PathVariable Long id,@RequestBody BookCategory updateBook )
   {
        updateBook.setBookcatId(id);
        return bookRepository.saveAndFlush(updateBook);
   }


   @RequestMapping(value="/{id}",method=RequestMethod.DELETE)
   public void  deletebook(@PathVariable Long id)
   {
         bookRepository.deleteById(id);
   }

    
}