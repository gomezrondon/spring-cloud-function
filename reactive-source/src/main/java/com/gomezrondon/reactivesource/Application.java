package com.gomezrondon.reactivesource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {

	@Value("${spring.kafka.bootstrap-servers:No_Kafka_IP_found}")
	private String kafkaIp;

	@Value("${function.generator.interval:5}")
	private Integer duration;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		System.out.println("++++++++++++++++++ "+ kafkaIp + " Interval: "+duration);
	}
}
