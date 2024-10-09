package com.work2win;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import com.work2win.model.Account;
import com.work2win.repository.AccountRepository;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
@ComponentScan(basePackages ="com.work2win")
public class SpringBootKafkaSampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootKafkaSampleApplication.class, args);
	}
	
	@Autowired
	private AccountRepository accountRepository;
	
	@Bean
	CommandLineRunner runner() {
		
		return args -> {
			List<Account> account = accountRepository.findAll();
			if(account.isEmpty())
				System.out.println("");
			else
				System.out.println("");		
		};
	}

}
