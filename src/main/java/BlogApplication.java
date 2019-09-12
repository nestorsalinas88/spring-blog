package com.codeup.blog;

import static org.springframework.boot.SpringApplication.run;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration;


@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
public class BlogApplication {

	public static void main(String[] args) {



	    run(BlogApplication.class, args);



	}
}



