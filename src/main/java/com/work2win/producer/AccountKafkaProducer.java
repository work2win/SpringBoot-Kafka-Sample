package com.work2win.producer;

import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import com.work2win.model.Account;

public class AccountKafkaProducer {
	
	static Logger logger = Logger.getLogger(AccountKafkaProducer.class.getName());
	String topicName = "accountTopic";
    Properties properties = new Properties();
    
    public void kafkaPublish_account(List<Account> accounts) {
    	properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        
        //Kafka Producer is defined in Apache Kafka
        KafkaProducer<String, String> kafkaProducer = new KafkaProducer(properties);
        
        for(int i = 0; i<accounts.size();i++) {
        	
        int accountNum = accounts.get(i).getAccountnum();
        String accountName = accounts.get(i).getName();
        
        String kafkaMessage = "Account "+accountNum+" created for customer "+accountName;
        
        ProducerRecord<String, String> producerRecord = new ProducerRecord<String, String>(topicName, kafkaMessage);
                
	        try {
				kafkaProducer.send(producerRecord).get();
				logger.log(Level.INFO, "message sent");
			} catch (Exception e) {
				
				e.printStackTrace();
				e.getStackTrace();
			}    
        }
        kafkaProducer.flush();
        kafkaProducer.close();        
    
    }

}
