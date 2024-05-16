package com.example.Second;

public class Alien {
	private int age;
	private Computer comp;
	
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


	public Computer getComp() {
		return comp;
	}


	public void setComp(Computer comp) {
		this.comp = comp;
	}


	public void code() {
		System.out.println("I am coding...");
		comp.compile();
	}

}
