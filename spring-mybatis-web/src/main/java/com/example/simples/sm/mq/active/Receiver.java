package com.example.simples.sm.mq.active;

import java.io.UnsupportedEncodingException;

import org.apache.activemq.command.ActiveMQMessage;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Receiver {

	@JmsListener(destination = "mailbox", containerFactory = "myFactory")
	public void receiveMessage(ActiveMQMessage message) throws UnsupportedEncodingException {
		String msg = new String(message.getContent().getData(), "UTF-8");
		System.out.println("Received <" + msg + ">");
	}

}
