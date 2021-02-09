package com.cts.flight.controller;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;

@Controller
public class Sender {

	@Autowired
	private RabbitTemplate rt;

	@Bean
	public Queue q1() {
		return new Queue("TestQ", false);
	}

	@Bean
	public void sendCustomMessage() {
		rt.convertAndSend("TestQ","This is the message for Consumer application...");
	}

}
