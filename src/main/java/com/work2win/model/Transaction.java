package com.work2win.model;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import lombok.Builder;
import lombok.Data;
import java.util.UUID;

@Data
@Builder
@Table("transaction")
public class Transaction {
	
	
	
	@PrimaryKey
	private int accountnum;
	private UUID transactionID;
	private Date date;
	private String refOrcheckNo;
	private float debit;
	private float credit;
	private float balance;
	
	@Autowired
	public Transaction() {}
	
	@Autowired
	public Transaction(int accountnum, UUID transactionID, Date date, String refOrcheckNo, float debit, float credit,
			float balance) {
		super();
		this.accountnum = accountnum;
		this.transactionID = transactionID;
		this.date = date;
		this.refOrcheckNo = refOrcheckNo;
		this.debit = debit;
		this.credit = credit;
		this.balance = balance;
	}

	public int getAccountnum() {
		return accountnum;
	}

	public void setAccountnum(int accountnum) {
		this.accountnum = accountnum;
	}

	public UUID getTransactionID() {
		return transactionID;
	}

	public void setTransactionID(UUID transactionID) {
		this.transactionID = transactionID;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getRefOrcheckNo() {
		return refOrcheckNo;
	}

	public void setRefOrcheckNo(String refOrcheckNo) {
		this.refOrcheckNo = refOrcheckNo;
	}

	public float getDebit() {
		return debit;
	}

	public void setDebit(float debit) {
		this.debit = debit;
	}

	public float getCredit() {
		return credit;
	}

	public void setCredit(float credit) {
		this.credit = credit;
	}

	public float getBalance() {
		return balance;
	}

	public void setBalance(float balance) {
		this.balance = balance;
	}
	
	
	
	

}
