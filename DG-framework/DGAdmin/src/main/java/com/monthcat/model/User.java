package com.monthcat.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name="user")
@Table(name = "test_user")
public class User implements java.io.Serializable {

	private int id;
	private String username;
	private String password;
	private int cookie_time;
	private String webkey;

	public User(){
		
	}
	
	public User(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public User(int id, String username, String password, int cookie_time,
			String webkey) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.cookie_time = cookie_time;
		this.webkey = webkey;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id", nullable = true, length = 11)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "username", nullable = false, length = 40)
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "password", nullable = false, length = 32)
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "cookie_time", nullable = true, length = 11)
	public int getCookie_time() {
		return cookie_time;
	}

	public void setCookie_time(int cookie_time) {
		this.cookie_time = cookie_time;
	}

	@Column(name = "webkey", nullable = true, length = 50)
	public String getWebkey() {
		return webkey;
	}

	public void setWebkey(String webkey) {
		this.webkey = webkey;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password="
				+ password + ", cookie_time=" + cookie_time + ", webkey="
				+ webkey + "]";
	}
	
}
