package com.trilogyed.stwittercloudservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class StwitterCloudServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(StwitterCloudServiceApplication.class, args);
	}

}
