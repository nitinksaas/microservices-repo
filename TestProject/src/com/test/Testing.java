package com.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

final class Employee {
	private String name;
	private List<String> skills;

	public Employee(String name, List<String> skills) {
		super();
		this.name = name;
		// this.skills = new ArrayList<>(skills);
		ArrayList<String> arr = new ArrayList<>();
		for (Iterator iterator = skills.iterator(); iterator.hasNext();) {
			String string = (String) iterator.next();

			arr.add(string);

		}

		this.skills = new ArrayList<>(arr);

	}

	public String getName() {
		return name;
	}

	public List<String> getSkills() {
		return new ArrayList<String>(this.skills);
	}

}

public class Testing {

	public static void main(String[] args) {
		
		ExecutorService executor = Executors.newFixedThreadPool(3);
		
		List<String> names = List.of("Nitin", "Rahul", "Amit");

		List<Integer> result2 = names.stream()
		    .filter(name -> name.length() > 4) // select
		    .map(String::length)               // transform
		    .collect(Collectors.toList());

		List<String> emplist = new ArrayList<>();
		emplist.add("Java");

		Employee e = new Employee("Nitin", emplist);

		emplist.add("Spring"); // 😱 modifies internal state

		System.out.println(result2);

		String s1 = "Hello";
		String s2 = "Hellso";

		System.out.println(s1 == s2);

		String s = "abcabcdbbabcdeabcd";

		String append1 = "";

		char c[] = s.toCharArray();

		HashSet<String> hashset = new HashSet<String>();

		for (int j = 0; j < s.toCharArray().length; j++) {

			if (!append1.contains(String.valueOf(c[j]))) {

				append1 += c[j];

				// break;

			} else {

				hashset.add(append1);
			}

		}

		int maxLength = 0;
		String result = null;
		for (Iterator iterator = hashset.iterator(); iterator.hasNext();) {
			String string = (String) iterator.next();

			if (string.length() > maxLength) {
				maxLength = string.length();

				result = string;
			}

		}

		System.out.print(result);
		// }

		List<Vehicle> vehicleList = new ArrayList<Vehicle>();
		vehicleList.add(new Vehicle("blue", 1, 101));
		vehicleList.add(new Vehicle("black", 4, 102));
		vehicleList.add(new Vehicle("red", 3, 103));
		vehicleList.add(new Vehicle("yellow", 4, 104));
		vehicleList.add(new Vehicle("blue", 4, 105));
		vehicleList.add(new Vehicle("red", 3, 106));
		vehicleList.add(new Vehicle("black", 4, 107));
		vehicleList.add(new Vehicle("blue", 4, 108));
		vehicleList.add(new Vehicle("red", 3, 109));
		vehicleList.add(new Vehicle("black", 4, 110));

		// Map<Integer, String> -- veh id and color new HashMap<Integer,
		// String>().put(v.id, v.color)

		// Map<String, List<Vehicle>>

		Map<Object, Optional<Vehicle>> map = vehicleList.stream()
				.collect(Collectors.groupingBy(v -> v.color, Collectors.maxBy(Comparator.comparing(Vehicle::getAge))));

		System.out.println(map);

		List<String> car = new ArrayList<String>();

		car.add("bmw");
		car.add("mercedes");
		car.add("porshe");
		car.add("minicooper");
		car.add("maserite");

		Predicate<String> printCar = carName -> carName.startsWith("m");

		// car.forEach( c -> System.out.println (printCar.test(c)));

		List<List<Integer>> list = Arrays.asList(Arrays.asList(1, 2, 4), Arrays.asList(3, 4, 6), Arrays.asList(5, 6));

		list.stream().flatMap(l -> l.stream())
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

		List<Employee> employees = new ArrayList<Employee>();
		List<String> skill = new ArrayList<String>();
		skill.add("coaching");
		skill.add("golly");
		skill.add("kolp");

		List<String> skill2 = new ArrayList<String>();
		skill2.add("lomp");
		skill2.add("boaching");
		skill2.add("golly");

		List<String> skill3 = new ArrayList<String>();
		skill3.add("tomp");
		skill3.add("lomp");
		skill3.add("kolp");

		employees.add(new Employee("suresh", skill));
		employees.add(new Employee("nilesh", skill3));
		employees.add(new Employee("ramesh", skill2));

		// Predicate<List<String>> unqiue = uSkill -> uSkill.contains(employees.);

		// employees.stream().flatMap(emp -> emp.skills.stream())
		// .collect(Collectors.groupingBy(Function.identity(),
		// Collectors.counting())).entrySet().stream()
		// .filter(e -> e.getValue() == 1).collect(Collectors.toList()).forEach(k ->
		// System.out.println(k));

	}

}
