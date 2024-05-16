package com.example.Second;

public class Alien {
	private int age;
	private Laptop lap;
	
//	public Alien(){
//		System.out.println("Alien object created....");
//	}
	
	public Alien(int age) {
		super();
		this.age=age;
		System.out.println("Alien object created....using parameterized constructor");
	}
	
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		System.out.println("Setting Age...");
		this.age = age;
	}

	public Laptop getLap() {
		return lap;
	}

	public void setLap(Laptop lap) {
		this.lap = lap;
	}

	public void code() {
		System.out.println("I am coding...");
		lap.compile();
	}

}
