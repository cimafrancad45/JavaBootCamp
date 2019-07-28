package com.trilogyed.taskereurekaservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class TaskerEurekaServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaskerEurekaServiceApplication.class, args);
	}

}
