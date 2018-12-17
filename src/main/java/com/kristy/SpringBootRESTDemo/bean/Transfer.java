package com.kristy.SpringBootRESTDemo.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "Transfer")
public class Transfer {
	@Id
	@GeneratedValue(strategy =  GenerationType.AUTO, generator = "SEQ")
	@SequenceGenerator(name = "SEQ", sequenceName = "TRANSFER_SEQ")
	private int id;
	@Column
	private String fromaccount;
	@Column
	private String toaccount;
	@Column
	private float amount;
	
	public Transfer() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Transfer(int id, String fromaccount, String toaccount, float amount) {
		super();
		this.id = id;
		this.fromaccount = fromaccount;
		this.toaccount = toaccount;
		this.amount = amount;
	}


	
	public String getFromaccount() {
		return fromaccount;
	}


	public void setFromaccount(String fromaccount) {
		this.fromaccount = fromaccount;
	}


	public String getToaccount() {
		return toaccount;
	}


	public void setToaccount(String toaccount) {
		this.toaccount = toaccount;
	}


	public float getAmount() {
		return amount;
	}


	public void setAmount(float amount) {
		this.amount = amount;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	@Override
	public String toString() {
		return "Transfer [id=" + id + ", fromaccount=" + fromaccount + ", toaccount=" + toaccount + ", amount=" + amount
				+ "]";
	}

	
	
	}
