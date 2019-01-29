package com.capgemini.transactionservice.sender;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitMessagingTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.capgemini.transactionservice.app.entity.Transaction;

/**
 * @author ugawari
 *
 */
@Component
public class Sender {
	
	@Autowired
	private RabbitMessagingTemplate template;
	
	@Bean
	public Queue queue() {
		return new Queue("updateBalance", false);
	}
	
	/*
	 * public void send(Transaction transaction) {
	 * template.convertAndSend("updateBalance", transaction); }
	 */
	
	public void send(Transaction transaction) {
		template.convertAndSend("updateBalance", transaction);
	}

}
