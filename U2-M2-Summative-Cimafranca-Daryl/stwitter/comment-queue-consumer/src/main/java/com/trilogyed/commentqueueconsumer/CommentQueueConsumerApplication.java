package com.trilogyed.commentqueueconsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class CommentQueueConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CommentQueueConsumerApplication.class, args);
	}

	public static final String COMMENT_QUEUE = "comment-exchange";

}
