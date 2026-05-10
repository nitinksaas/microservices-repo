package com.test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.test.Person.Shape;

class Person {

	public Person() {

	}

	public record Shape(int a, int b) {

	}

}

class Employees {

	int id;
	String name;
	String department;
	int salary;

	Employees(int id, String name, String department, int salary) {
		this.id = id;
		this.name = name;
		this.department = department;
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employees [name=" + name + "]";
	}

}

class Preps {
	public static void main(String[] args) {
		
		
		
		
	}
}