package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class FirstApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(FirstApplication.class, args);
		
//		This is dependency injection because we are giving the responsibility of creating 
//		an object of class to Spring so it will create the object at runtime
//		Instead of creating the object at compile time using Alien obj=new Alien()
//		The getBean method belongs to an interface ApplicationContext 
//		So if we want to call getBean method we need an object of ApplicationContext
//		and the above run method is basically creating an object of ConfigurableApplicationContext
//		which is an interface which extends ApplicationContext...which indicates that run is
//		actually giving us the object of ApplicationContext so we can store its reference
//		 and using that object reference we can call getBean method.
		Alien obj=context.getBean(Alien.class);
		obj.code();
	}

}
