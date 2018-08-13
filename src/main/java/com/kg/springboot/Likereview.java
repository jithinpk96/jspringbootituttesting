package com.kg.springboot;
import javax.persistence.*;
@Entity
public class Likereview {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long likeid;
@Column
private Long bookrewid; 
@Column
private String Likestatus;
@Column
private String vote;
@Column
private String comments;
@Column
private Long userid;
public void setLikeid(Long likeid) {
this.likeid = likeid;
}
public Long getLikeid() {
return likeid;
}
public void setLikestatus(String likestatus) {
this.Likestatus = likestatus;
}
public String getLikestatus() {
return Likestatus;
}
public void setVote(String vote) {
this.vote = vote;
}
public String getVote() {
return vote;
}
public void setComments(String comments) {
this.comments = comments;
}
public String getComments() {
return comments;
}
public void setUserid(Long userid) {
this.userid = userid;
}
public void setBookrewid(Long bookrewid) {
this.bookrewid = bookrewid;
}
public Long getBookrewid() {
return bookrewid;
}
public Long getUserid() {
return userid;
}
@Override
public String toString() {
return likeid+" "+Likestatus+" "+vote+" "+comments+" "+userid+" " +bookrewid;
}
}