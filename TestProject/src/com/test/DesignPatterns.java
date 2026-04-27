package com.test;

class Singleton {
	
	private final static Singleton singleton = new Singleton();

	private Singleton() {

	}

	public static synchronized Singleton getInstance() {

		return singleton;
	}
}

public class DesignPatterns {
	public static void main(String[] args) {

		Singleton singleton = Singleton.getInstance();

	}
}
