package com.kristy.SpringBootRESTDemo.bean;

import java.sql.Date;
import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "ACCOUNT_ACTIVITY")
public class AccountActivity {
	@Id
	@GeneratedValue(strategy =  GenerationType.AUTO, generator = "SEQ")
	@SequenceGenerator(name = "SEQ", sequenceName = "ACCOUNT_ACTIVITY_SEQ")
	private int id;
	@Column
	private String accountnumber;
	@Column 
	private float amount;
	@Column 
	private float pre_balance;
	@Column 
	private float post_balance;
	@Column
	private String description;
	@Column
	private String category;
	@Column
	private Date timestamp;
	public AccountActivity() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public AccountActivity(int id, String accountnumber, float amount, float pre_balance, float post_balance,
			String description, String category, Date timestamp) {
		super();
		this.id = id;
		this.accountnumber = accountnumber;
		this.amount = amount;
		this.pre_balance = pre_balance;
		this.post_balance = post_balance;
		this.description = description;
		this.category = category;
		this.timestamp = timestamp;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAccountnumber() {
		return accountnumber;
	}
	public void setAccountnumber(String accountnumber) {
		this.accountnumber = accountnumber;
	}
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	
	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
	
	public float getPre_balance() {
		return pre_balance;
	}


	public void setPre_balance(float pre_balance) {
		this.pre_balance = pre_balance;
	}


	public float getPost_balance() {
		return post_balance;
	}


	public void setPost_balance(float post_balance) {
		this.post_balance = post_balance;
	}


	@Override
	public String toString() {
		return "AccountActivity [id=" + id + ", accountnumber=" + accountnumber + ", amount=" + amount
				+ ", pre_balance=" + pre_balance + ", post_balance=" + post_balance + ", description=" + description
				+ ", category=" + category + ", timestamp=" + timestamp + "]";
	}


	

}
