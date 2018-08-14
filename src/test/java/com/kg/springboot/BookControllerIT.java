package com.kg.springboot;

import org.junit.runner.RunWith;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import com.jayway.restassured.RestAssured;
import static com.jayway.restassured.RestAssured.when;
import org.apache.http.HttpStatus;
import com.jayway.restassured.http.ContentType;
import com.kg.springboot.model.BookCategory;
import com.kg.springboot.repository.BookRepository;

import static org.hamcrest.Matchers.*;
import static com.jayway.restassured.RestAssured.given;

/**
 * BookControllerIT
 * 
 */

@RunWith(SpringRunner.class)

@SpringBootTest(classes = SpringbootApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:application.properties")
public class BookControllerIT {
    @Value("${local.server.port}")
    private int serverPort;
    private static final String FIRST_NAME_FIELD = "name";
    private static final String EVENT_RESOURCE1 = "books";
    private static final String EVENT_RESOURCE2 = "books";
    private static final String EVENT_RESOURCE3 = "books/{bookId}";
    private static final String EVENT_RESOURCE5 = "books/{bookId}";
    private static final String EVENT_RESOURCE4 = "books/{bookId}";
    private static final String name = "Malala";

    private static final Long EVENT_ID = 1L;
    private static final BookCategory FIRST_EVENT = new BookBuilder().BookCategoryId(EVENT_ID).Name("name").Build();
    private static final BookCategory SECOND_EVENT = new BookBuilder().BookCategoryId(2L).Name("Malala").Build();
    private static final BookCategory THIRD_EVENT = new BookBuilder().BookCategoryId(3L).Name("Malala").Build();

    private BookCategory firstEvent;
    private BookCategory secondEvent;
    @Autowired
    private BookRepository bookRepository;

    @Before
     public void setUp() {
        bookRepository.deleteAll();
        firstEvent = bookRepository.saveAndFlush(FIRST_EVENT);
        secondEvent = bookRepository.saveAndFlush(SECOND_EVENT);
        RestAssured.port = serverPort;
    }
   @Test
    // GET ALL EVENTS
   public void getAll() {
        when().get(EVENT_RESOURCE1).then().statusCode(HttpStatus.SC_OK).body(FIRST_NAME_FIELD,
                hasItems(name, name));
    }

   @Test
   // POST
   public void add() {
       given().body(THIRD_EVENT).contentType(ContentType.JSON).when().post(EVENT_RESOURCE2).then()
               .statusCode(HttpStatus.SC_OK);

   }

    @Test
    public void updateById() {

        given().body(THIRD_EVENT).contentType(ContentType.JSON).when().put(EVENT_RESOURCE3, firstEvent.getBookcatId())
                .then().statusCode(HttpStatus.SC_OK).body(FIRST_NAME_FIELD, is(name));

    }

    @Test
    // DELETE
    public void deleteById() {
        when().delete(EVENT_RESOURCE4, secondEvent.getBookcatId()).then().statusCode(HttpStatus.SC_OK);
    }

    @Test
    public void getOneItemsById() {
        when().get(EVENT_RESOURCE5, firstEvent.getBookcatId()).then().statusCode(HttpStatus.SC_BAD_REQUEST);

    }
}
