package com.kg.springboot.model;
// import java.util.List;
import javax.persistence.*;
@Entity
@Table(name = "book_category")
public class BookCategory {
@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
private Long bookcatId;


@Column
private String name;



// private List<BookCategory> book;
public BookCategory() { }

// @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)

//     @JoinColumn(name = "bookcatId")

public Long getBookcatId() {
        return bookcatId;
    }
    public void setBookcatId(Long bookcatId) {
        this.bookcatId = bookcatId;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    // public List<BookCategory> getBook() {
    //     return book;
    // }
    // public void setBook(List<BookCategory> book) {
    //    this.book = book;
    // }
	// @Override
	// public String toString() {
	// 	return "Book [bookcatId=" +getBookcatId() + ",name=" +getName() + "]";
	// }

	// public void setBookCategoryId(Object bookControllerId) {
	// }

	// public void setname(String name2) {
	// }
    
}









