package com.ikefukuro.hahaloss;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;

@SpringBootApplication
public class HahalossApplication  extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(HahalossApplication.class, args);
	}
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(HahalossApplication.class);
    }
}

