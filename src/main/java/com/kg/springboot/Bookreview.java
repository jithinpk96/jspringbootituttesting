package com.kg.springboot;
import javax.persistence.*;
@Entity
public class Bookreview {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long bookrevid;
@Column
private Long bookid;
@Column
private String review;
@Column
private Long userid;
public void setBookrevid(Long bookrevid) {
this.bookrevid = bookrevid;
}
public Long getBookrevid() {
return bookrevid;
}
public void setBookid(Long bookid) {
this.bookid = bookid;
}
public Long getBookid() {
return bookid;
}
public void setreview(String review) {
this.review = review;
}
public String getreview() {
return review;
}
public void setUserid(Long userid) {
this.userid = userid;
}
public Long getUserid() {
return userid;
}
@Override
public String toString() {
return bookrevid+" "+bookid+" "+review+" "+userid;
}
}
