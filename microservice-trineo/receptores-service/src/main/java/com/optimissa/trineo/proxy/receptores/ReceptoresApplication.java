package com.optimissa.trineo.proxy.receptores;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Import;

import com.optimissa.trineo.proxy.receptores.config.ReceptoresConfig;
/**
 * Run as a micro-service, registering with the Discovery Server (Eureka).
 * <p>
 * Note that the configuration for this application is imported from
 * {@link ReceptoresConfig}. This is a deliberate separation of concerns.
 * 
 * @author Rolando Lorenzo Lopez
 */
@EnableAutoConfiguration
@EnableDiscoveryClient
@Import(ReceptoresConfig.class)
public class ReceptoresApplication {

	/**
	 * Run the application using Spring Boot and an embedded servlet engine.
	 * 
	 * @param args
	 *            Program arguments - ignored.
	 */
	public static void main(String[] args) {
		
		System.setProperty("spring.config.name", "receptores-server");
		SpringApplication.run(ReceptoresApplication.class, args);
	}

}
