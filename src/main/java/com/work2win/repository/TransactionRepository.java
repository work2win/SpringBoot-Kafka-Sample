package com.work2win.repository;

import org.springframework.data.cassandra.repository.CassandraRepository;

import com.work2win.model.Transaction;

public interface TransactionRepository extends CassandraRepository<Transaction, Integer>{

}
