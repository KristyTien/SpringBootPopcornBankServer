package com.kristy.SpringBootRESTDemo.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "msi_user_info")
public class UserInfo {
	
	@Id
	private int user_id;
	@Column
	private String username;
	@Column
	private String firstname;
	@Column
	private String lastname;
	@Column
	private String address;
	@Column
	private String city;
	@Column
	private String state;
	@Column
	private String zipcode;
	@Column
	private String checking_account;
	@Column
	private String saving_account;
	@Column
	private String email;

	
	
	public UserInfo() {
		super();
	}
	
	
	

	public UserInfo(int user_id, String username, String firstname, String lastname, String address, String city,
			String state, String zipcode, String checking_account, String saving_account, String email) {
		super();
		this.user_id = user_id;
		this.username = username;
		this.firstname = firstname;
		this.lastname = lastname;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zipcode = zipcode;
		this.checking_account = checking_account;
		this.saving_account = saving_account;
		this.email = email;
	}




	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	
	
	public String getEmail() {
		return email;
	}




	public void setEmail(String email) {
		this.email = email;
	}




	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	
	public String getChecking_account() {
		return checking_account;
	}


	public void setChecking_account(String checking_account) {
		this.checking_account = checking_account;
	}


	public String getSaving_account() {
		return saving_account;
	}


	public void setSaving_account(String saving_account) {
		this.saving_account = saving_account;
	}




	@Override
	public String toString() {
		return "UserInfo [user_id=" + user_id + ", username=" + username + ", firstname=" + firstname + ", lastname="
				+ lastname + ", address=" + address + ", city=" + city + ", state=" + state + ", zipcode=" + zipcode
				+ ", checking_account=" + checking_account + ", saving_account=" + saving_account + ", email=" + email
				+ "]";
	}

}
