package com.test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;


public record Demo (

  int num,
  String name
		
		) {
	
    public String getEmployeeInfo() {
        return name + " earns " + name;
    }
	

class Item {
	String items;

	public String getItems() {
		return items;
	}

	public void setItems(String items) {
		this.items = items;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.items;
	}
}

class Order {
	List<Item> items;

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	@Override
	public String toString() {
		return "Order [items=" + items + "]";
	}

}

class Employee1 {

	String name;
	int salary;

	Employee1(String name, int salary) {
		this.name = name;
		this.salary = salary;
	}

	public int getSalary() {
		return salary;
	}

	public String getName() {
		return name;
	}
}

 class Demo2 {

	public static void main(String[] args) {
		
		Demo Demo2 = new Demo(1, "abvc");
		
		
		
		List<Item> item = new ArrayList<Item>();
		Item item1 = new Item();
		item1.setItems("book1");
		Item item2 = new Item();
		item2.setItems("book2");
		Item item3 = new Item();
		item3.setItems("book3");

		item.add(item1);
		item.add(item2);
		item.add(item3);

		List<Item> itemMore = new ArrayList<Item>();
		Item item4 = new Item();
		item4.setItems("book4");

		Item item5 = new Item();
		item5.setItems("book5");

		Item item6 = new Item();
		item6.setItems("book4");

		Item item7 = new Item();
		item7.setItems("book5");

		itemMore.add(item4);
		itemMore.add(item5);
		itemMore.add(item6);
		itemMore.add(item7);

		Order order = new Order();
		order.setItems(item);

		Order order2 = new Order();
		order2.setItems(itemMore);

		List<Order> orders = new ArrayList<Order>();
		orders.add(order);
		orders.add(order2);
		System.out.println(orders);

		
		List<Item> items =
		        orders.stream()
		              .flatMap(ord -> ord.getItems().stream())
		              .toList();
		System.out.println(items);
	}
	
 }

