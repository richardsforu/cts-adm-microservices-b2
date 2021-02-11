package com.cts.flight.controller;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;

@Controller
public class Receiver {
	
	
	@Bean
	public Queue q1() {
		return new Queue("TestQ",false);
	}
	
	@RabbitListener(queues = {"TestQ"})
	public void readMessage(String msg) {
		System.out.println(">>>>>>>>>>>>>>>>>>>");
		System.out.println(msg);
		System.out.println("<<<<<<<<<<<<<<<<<<<<");;
	}
	

}
