package com.TrackThatTrackAdmin.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
//This is the class used to define the User blueprint

//Entity will specify that this is a entity and is mapped to a database table

@Entity
@Table(name="users")
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="email")
	private String email;
	
	@Column(name="password")
	private String password;
	
	@Column(name="user_name")
	private String userName;
	
	
	//defining the relationship with other tables
	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL, mappedBy="user")
	private List<UserRecord> userRecords = new ArrayList<>();
	
	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL, mappedBy="user")
	private List<UserWishRecord> userWishRecords = new ArrayList<>();

	
	public List<UserWishRecord> getUserWishRecords() {
		return userWishRecords;
	}


	public void setUserWishRecords(List<UserWishRecord> userWishRecords) {
		this.userWishRecords = userWishRecords;
	}

	//empty constructor
	public User() {
		
	}

	
	
	//getters and setters for all fields

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
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


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public List<UserRecord> getUserRecords() {
		return userRecords;
	}

	public void setUserRecords(List<UserRecord> userRecords) {
		this.userRecords = userRecords;
	}

	
//Override toString method
	@Override
	public String toString() {
		return "User [id=" + id + ", email=" + email + ", password=" + password + ", userName=" + userName + "]";
	}
}










