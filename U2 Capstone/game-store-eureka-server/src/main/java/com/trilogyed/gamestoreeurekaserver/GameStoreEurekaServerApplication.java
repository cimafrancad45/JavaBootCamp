package com.trilogyed.gamestoreeurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class GameStoreEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(GameStoreEurekaServerApplication.class, args);
	}

}
