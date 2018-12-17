package com.kristy.SpringBootRESTDemo.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "ACCOUNT")
public class Account {
	@Id
	@GeneratedValue(strategy =  GenerationType.AUTO, generator = "SEQ")
	@SequenceGenerator(name = "SEQ", sequenceName = "ACCOUNT_SEQ")
	private int id;
	@Column
	private String accountnumber;
	@Column 
	private int type;
	@Column 
	private float balance;
	@Column
	private int userid;
	
	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public Account(int id, String accountnumber, int type, float balance, int userid) {
		super();
		this.id = id;
		this.accountnumber = accountnumber;
		this.type = type;
		this.balance = balance;
		this.userid = userid;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
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
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	
	public float getBalance() {
		return balance;
	}

	public void setBalance(float balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", accountnumber=" + accountnumber + ", type=" + type + "]";
	}
	
	

}
