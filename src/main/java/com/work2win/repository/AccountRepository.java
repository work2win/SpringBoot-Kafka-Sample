package com.work2win.repository;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;
import com.work2win.model.Account;

@Repository
public interface AccountRepository extends CassandraRepository<Account, Integer> {	
	
}
