package com.kg.springboot;
import javax.persistence.*;
@Entity
public class BookRequest{
// bookreqid,userid, userid, status (Q/I/R)
@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookreqid;
@Column
private Long userid;
@Column String category;
@Column
private String book;
    @Column
private String status;
public Long getBookreqid() {
return bookreqid;
}
public void setBookreqid(Long bookreqid) {
this.bookreqid = bookreqid;
}
public Long getUserid() {
return userid;
}
public void setUserid(Long userid) {
this.userid = userid;
}
public String getCategory() {
return category;
}
public void setCategory(String category) {
this.category = category;
}
public String getBook() {
return book;
}
public void setBook(String book) {
this.book = book;
}
public String getStatus() {
return status;
}
public void setStatus(String status) {
this.status = status;
}
@Override
public String toString() {
return bookreqid+" "+book+" "+category+" "+status+" "+userid;
}
}