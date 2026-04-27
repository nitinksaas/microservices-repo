package com.test;

import java.util.*;

public class MemoryLeakDemo {

	// Static list → never garbage collected
	private static final List<byte[]> memoryLeakList = new ArrayList<>();

	public static void main(String[] args) throws InterruptedException {

		int counter = 0;

		while (true) {
			// Allocate 1MB array
			byte[] data = new byte[15 * 1024 * 1024];

			// Add to static list → reference retained
			memoryLeakList.add(data);

			counter++;

			System.out.println("Objects created: " + counter + " | List size: " + memoryLeakList.size());

			// Slow down to observe
			Thread.sleep(200);
		}
	}
}