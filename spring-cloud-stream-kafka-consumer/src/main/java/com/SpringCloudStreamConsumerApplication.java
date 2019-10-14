package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;

@SpringBootApplication
@EnableBinding(GreetingsStreams.class)
public class SpringCloudStreamConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudStreamConsumerApplication.class, args);
	}
	
	@StreamListener(GreetingsStreams.INPUT)
	public void handleGreetings(@Payload Greetings greetings) {
		System.out.println("Received greetings: {}"+ greetings);
	}

}
