package com.kuldeep.HMS.KuldeepHMS.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Contact {
	String name;
	@Id
	String mobile;
	String email;
	String subject;
	String message;

	public Contact() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Contact(String name, String mobile, String email, String subject, String message) {
		super();
		this.name = name;
		this.mobile = mobile;
		this.email = email;
		this.subject = subject;
		this.message = message;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "Contact [name=" + name + ", mobile=" + mobile + ", email=" + email + ", subject=" + subject
				+ ", message=" + message + "]";
	}

	
}
