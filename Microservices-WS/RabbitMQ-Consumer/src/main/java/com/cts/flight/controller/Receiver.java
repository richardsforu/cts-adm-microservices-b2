package com.cts.flight.controller;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Controller;

@Controller
public class Receiver {
	
	@RabbitListener(queues = {"TestQ"})
	public void readMessage(String msg) {
		System.out.println(">>>>>>>>>>>>>>>>>>>");
		System.out.println(msg);
		System.out.println("<<<<<<<<<<<<<<<<<<<<");;
	}
	

}
