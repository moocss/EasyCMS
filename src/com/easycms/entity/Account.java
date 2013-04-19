package com.easycms.entity;

import java.io.Serializable;

public class Account implements Serializable{
	private int id;
	private String username;
	public int getTid() {
		return id;
	}
	public void setTid(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	private String password;
}
