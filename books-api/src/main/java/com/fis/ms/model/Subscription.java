package com.fis.ms.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity	
@Table(name ="subscription", uniqueConstraints = @UniqueConstraint(columnNames = "id"))
public class Subscription {
//SUBSCRIBER_NAME DATE_SUBSCRIBED DATE_RETURNED BOOK_ID
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id" , nullable = false, unique = true)
	private Long id;
	
	private Date mDateSubscribed;
	private Date mDateReturned;
	@Column(name="subscribername" , nullable = false, unique = true)
	private String mSubscriberName;
	
	private Long bookid;
	
	public String getSubscriberName() {
		return mSubscriberName;
	}
	public void setSubscriberName(String subsname) {
		this.mSubscriberName = subsname;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getDateSubscribed() {
		return mDateSubscribed;
	}
	public void setDateSubscribed(Date mDateSubscribed) {
		this.mDateSubscribed = mDateSubscribed;
	}
	public Date getDateReturned() {
		return mDateReturned;
	}
	public void setDateReturned(Date mDateReturned) {
		this.mDateReturned = mDateReturned;
	}
	
	public Long getBookid() {
		return bookid;
	}
	
	public void setBookid(Long bookid) {
		this.bookid = bookid;
	}
}
