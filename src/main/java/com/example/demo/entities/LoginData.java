package com.example.demo.entities;

public class LoginData {
	String email;
	String password;
	@Override
	public String toString() {
		return "LoginData [email=" + email + ", password=" + password + "]";
	}
	public LoginData(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public LoginData() {
		super();
	}

}
