package com.stackroute.MovieApp;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaClient
public class MovieAppApplication {

	public static void main(String[] args) {

		SpringApplication.run(MovieAppApplication.class, args);
//		MovieAppStartup startup=new MovieAppStartup();
//		startup.onApplicationEvent();
	}

}

@RefreshScope
@RestController
class MessageRestController {
	@Value("${msg:Hello world - Config Server is not working..pelase check}")
	private String msg;
	@RequestMapping("/msg")
	String getMsg() {
		return this.msg;
	}
}

