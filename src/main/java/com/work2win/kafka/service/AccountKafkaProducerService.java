package com.work2win.kafka.service;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;

@Service
public class AccountKafkaProducerService {
	
	private final Logger logger = LoggerFactory.getLogger(AccountKafkaProducerService.class);
	
	private String topicName = "sample";
	
	@Autowired
    private KafkaTemplate<String, String> kafkaTemplateSample;
	
	public void samplePublish(String message) {
        logger.info("#### -> Publishing message -> {}", message);
        kafkaTemplateSample.send(topicName, message);
    }

}
