package com.kg.springboot;

import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.Mockito.when;
import com.kg.springboot.BookBuilder;
import com.kg.springboot.controller.BookController;
import com.kg.springboot.model.BookCategory;
import com.kg.springboot.repository.BookRepository;

import static org.mockito.Mockito.verify;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import java.util.Arrays;

/**
* EmployeeControllerTest
*/
@RunWith(SpringRunner.class)

public class BookControllerTest {
   // List<Employee> expectedEmployees;
   @InjectMocks
   public BookController bookController; 
   @Mock
   public BookRepository bookRepository;

   private static final long BOOK_ID = 1L;
    private static final BookCategory EXISTING_BOOK_CATEGORY = new BookBuilder().BookCategoryId(1L).Name("Malala").Build();
    // private static final Employee ANOTHER_EMPLOYEE = new EmployeeBuilder().EmployeeId(2L).Department("def").Build();
   private static final BookCategory NEW_BOOK_CATEGORY = new BookBuilder().BookCategoryId(2L).Name("Malala").Build();
   private static final Optional<BookCategory> EXISTING_BOOK_CATEGORY1=Optional.of(EXISTING_BOOK_CATEGORY);
   
   
   List<BookCategory> expectedEmployees=Arrays.asList(EXISTING_BOOK_CATEGORY);
   
   @Test
   public void readTest()
    {   
        when(bookRepository.findAll()).thenReturn(expectedEmployees);
       Iterable<BookCategory> actEmployee=bookController.read();
       assertNotNull(actEmployee);
       // assertEquals(1, actEmployee.size());
       assertEquals(expectedEmployees, actEmployee);

   }

   @Test
   public void readOneTest()
    {   
        when(bookRepository.findById(BOOK_ID)).thenReturn(EXISTING_BOOK_CATEGORY1);
       Optional<BookCategory> actEmployee=bookController.readOne(BOOK_ID);
       assertNotNull(actEmployee);
       // assertEquals(1, actEmployee.size());
       // assertEquals(expectedEmployees, actEmployee);

   }

   @Test
   public void addbookTest() {
       when(bookRepository.saveAndFlush(NEW_BOOK_CATEGORY)).thenReturn(EXISTING_BOOK_CATEGORY);
       BookCategory AR = bookController.add(NEW_BOOK_CATEGORY);
       assertNotNull(AR);
   }

   @Test
   public void deletbookTest() {
       bookController.deletebook(BOOK_ID);
       verify(bookRepository).deleteById(BOOK_ID);

   }

   @Test
   public void updatebookTest() {
       when(bookRepository.findById(BOOK_ID)).thenReturn(EXISTING_BOOK_CATEGORY1);
       when(bookRepository.saveAndFlush(NEW_BOOK_CATEGORY)).thenReturn(NEW_BOOK_CATEGORY);
       BookCategory AR = bookController.update(BOOK_ID,NEW_BOOK_CATEGORY);
       System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$"+AR);
       assertNotNull(AR);
   }

}

