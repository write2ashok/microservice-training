package com.fis.ms.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "user", uniqueConstraints = @UniqueConstraint(columnNames = "id"))
public class User {

	// ID SUBSCRIBER_NAME PASSWORD EMAIL
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false, unique = true)
	private Long id;

	@Column(name = "subscribername", nullable = false, unique = true)
	private String subscriberName;
	@Column(name = "password")
	private String password;
	@Column(name = "email")
	private String eMail;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSubscriberName() {
		return subscriberName;
	}

	public void setSubscriberName(String subsname) {
		this.subscriberName = subsname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String pwd) {
		this.password = pwd;
	}

	public String getEMail() {
		return eMail;
	}

	public void setEMail(String email) {
		this.eMail = email;
	}

}
