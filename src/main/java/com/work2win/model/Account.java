package com.work2win.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.cassandra.core.mapping.Table;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;

@Data
@Builder
@Table("account")
public class Account {
	
	@PrimaryKey
	private int accountnum;
	private String name;
	private float balance;
	
	@Autowired
	public Account() {}
	
	@Autowired
	public Account(int accountnum, String name, float balance) {
		super();
		
		this.accountnum = accountnum;
		this.name = name;
		this.balance = balance;
	}
	
	
	public int getAccountnum() {
		return accountnum;
	}
	public void setAccountnum(int accountnum) {
		this.accountnum = accountnum;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getBalance() {
		return balance;
	}
	public void setBalance(float balance) {
		this.balance = balance;
	}
		

}
