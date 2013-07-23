package com.monthcat.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "user")
@Table(name = "dg_user")
public class User implements java.io.Serializable {

	private int user_id;
	private String user_name;
	private String user_password;
	private String user_mail;
	private String user_desc;
	private int enable;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(int user_id, String user_name, String user_password,
			String user_mail, String user_desc, int enable) {
		super();
		this.user_id = user_id;
		this.user_name = user_name;
		this.user_password = user_password;
		this.user_mail = user_mail;
		this.user_desc = user_desc;
		this.enable = enable;
	}

	public User(String user_name, String user_password) {
		super();
		this.user_name = user_name;
		this.user_password = user_password;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id", nullable = true, length = 11)
	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	@Column(name = "user_name", nullable = false, length = 100)
	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	@Column(name = "user_password", nullable = false, length = 32)
	public String getUser_password() {
		return user_password;
	}

	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}

	@Column(name = "user_mail", nullable = true, length = 100)
	public String getUser_mail() {
		return user_mail;
	}

	public void setUser_mail(String user_mail) {
		this.user_mail = user_mail;
	}

	@Column(name = "user_desc", nullable = true, length = 200)
	public String getUser_desc() {
		return user_desc;
	}

	public void setUser_desc(String user_desc) {
		this.user_desc = user_desc;
	}

	@Column(name = "enable", nullable = true, length = 11)
	public int getEnable() {
		return enable;
	}

	public void setEnable(int enable) {
		this.enable = enable;
	}

}
