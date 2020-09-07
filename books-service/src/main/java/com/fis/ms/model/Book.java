package com.fis.ms.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity	
@Table(name ="book", uniqueConstraints = @UniqueConstraint(columnNames = "id"))
public class Book {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id" , nullable = false, unique = true)
	private Long id;
	
	private String mBookName;
	private String mAuthor;
	private int mAvailableCopies;
	private int mTotalCopies;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getBookName() {
		return mBookName;
	}
	public void setBookName(String mBookName) {
		this.mBookName = mBookName;
	}
	public String getAuthor() {
		return mAuthor;
	}
	public void setAuthor(String mAuthor) {
		this.mAuthor = mAuthor;
	}
	public int getAvailableCopies() {
		return mAvailableCopies;
	}
	public void setAvailableCopies(int mAvailableCopies) {
		this.mAvailableCopies = mAvailableCopies;
	}
	public int getTotalCopies() {
		return mTotalCopies;
	}
	public void setTotalCopies(int mTotalCopies) {
		this.mTotalCopies = mTotalCopies;
	}
	
	
	
}
