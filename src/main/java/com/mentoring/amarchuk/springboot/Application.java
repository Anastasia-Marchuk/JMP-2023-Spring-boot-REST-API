package com.mentoring.amarchuk.springboot;

import lombok.extern.log4j.Log4j2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;

@Log4j2
@SpringBootApplication
public class Application {
	Logger log = LoggerFactory.getLogger(Application.class);

//		public static void main(String[] args) {
//		SpringApplication.run(Application.class, args);
//
//	}
//	@Bean
//	ApplicationRunner applicationRunner(Environment environment) {
//		return args -> {
//			log.info("message from application.properties " + environment.getProperty("message-from-application-properties"));
//		};
//	}


	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication
				.run(Application.class, args);

		for (String name : applicationContext.getBeanDefinitionNames()) {
			System.out.println(name);
		}
	}

	@Profile("dev")
	@Bean
	public String devBean() {
		return "dev";
	}

	@Profile("local")
	@Bean
	public String localBean() {
		return "local";
	}

	@Profile("stg")
	@Bean
	public String stgBean() {
		return "stg";
	}

	@Profile("prod")
	@Bean
	public String prodBean() {
		return "prod";
	}


}
