package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

// This @component will make sure that spring knows that he is responsible for creating
// the object of Alien class

@Component
public class Alien {
	
//	Here auto-wired will automatically instantiate the object of Laptop class at runtime
//	So when we run our program there will be two objects created in the beginning one of Alien
//	class and other one is of Laptop class... when we call the code method from main the execution
//	flow will come over here it will ask that if we have laptop class object with us or not ..
//	since yes we do have it because of auto-wired it will assign the assign the reference of that
//	object to lap and our compile method will get called and executed
	@Autowired
	Laptop lap;
	
	void code() {
		lap.compile();
	}

}
