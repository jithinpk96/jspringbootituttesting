package com.kg.springboot;

import com.kg.springboot.controller.BookController;
import com.kg.springboot.model.BookCategory;

public class BookBuilder {
    
       private Long bookcatId;
       private String name;
       
       /**
        * @param bookcontrollerId the bookcontroller to set
        *
        */
       BookCategory bookCategory=new BookCategory();
    
       public BookBuilder BookCategoryId(Long bookcatId) {
           bookCategory.setBookcatId(bookcatId);
           return this;
       }
       /**
        * @param firstName the firstName to set
        */
       public BookBuilder Name(String name) {
           bookCategory.setName(name);
           return this;
       }
    
    public BookCategory Build()
    {
       return bookCategory;
    }
	    
    }