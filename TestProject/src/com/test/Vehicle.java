package com.test;

public class Vehicle {

	String color;
	long id;
	int age;

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Vehicle(String color, long id, int age) {
		super();
		this.color = color;
		this.id = id;
		this.age = age;
	}

	@Override
	public String toString() {
		return "Vehicle = id=" + age ;
	}

	
	
}
