package com.visitor.visitorsbook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableAspectJAutoProxy
@SpringBootApplication
public class VisitorsbookSpringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(VisitorsbookSpringbootApplication.class, args);
	}

}
