package com.example.Second;

public class Alien {
	
	private int age;
	
	public Alien(){
		System.out.println("Alien object created....");
	}
	
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		System.out.println("Setting Age...");
		this.age = age;
	}

	public void code() {
		System.out.println("I am coding...");
	}

}
