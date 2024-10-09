package com.work2win.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.work2win.model.Transaction;
import com.work2win.repository.TransactionRepository;

import org.springframework.data.cassandra.core.convert.*;

@RestController
@RequestMapping("/")
public class TransactionController {
	
	@Autowired
	TransactionRepository transactionRepository;
	
	@GetMapping("transaction")
	public List<Transaction> getTransactions(){
		return transactionRepository.findAll();
	}

}
