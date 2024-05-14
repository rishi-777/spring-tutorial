package com.example.demo;

import org.springframework.stereotype.Component;

// This @component will make sure that spring knows that he is responsible for creating
// the object of Alien class
@Component
public class Alien {
	void print() {
		System.out.println("I am coding ...");
	}

}
