package com.work2win.kafka.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.work2win.kafka.service.AccountKafkaProducerService;
import com.work2win.model.Account;
import com.work2win.repository.AccountRepository;

@RestController
@RequestMapping("/")
public class AccountKafkaProducerController {
	
	@Autowired
	AccountRepository accountRepository;
		
	@Autowired
	private KafkaTemplate<String, Object> kafkaTemplate;
	
	@Autowired
	private AccountKafkaProducerService accountKafkaProducerService;
	
	public static final String TOPIC_NAME = "accountTopicSample";
	
	
	@GetMapping("sample")
	public String sendMessageKafka() {
		
		String kafkamsg = "Test Sample Publish";
		accountKafkaProducerService.samplePublish(kafkamsg);		
		return " Sample message published";
		
	}			
	
	//The KafkaTemplate is Spring's implementation of it (although it does not implement Producer directly) and so it provides more methods for you to use.
	
	@GetMapping("account")
	public String getAccounts() {
				
		List<Account> accounts = accountRepository.findAll();
		if(accounts != null)
			kafkaTemplate.send(TOPIC_NAME,accounts);
		
		return "account published";
	}

}
