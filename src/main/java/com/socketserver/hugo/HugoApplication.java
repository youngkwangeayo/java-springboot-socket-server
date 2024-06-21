package com.socketserver.hugo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.scheduling.annotation.EnableAsync;

// @EnableAsync
@SpringBootApplication
public class HugoApplication extends SpringBootServletInitializer implements CommandLineRunner{
	
	@Value("${server.port}")
    private int serverPort;
	
	public static void main(String[] args) {
		SpringApplication.run(HugoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("WebSocket server is running on port " + serverPort);
		// throw new UnsupportedOperationException("Unimplemented method 'run'");
	}

}
