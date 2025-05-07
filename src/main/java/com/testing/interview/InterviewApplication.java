package com.testing.interview;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class InterviewApplication {

	public static void main(String[] args) {
		SpringApplication.run(InterviewApplication.class, args);
		System.out.println(Integer.toBinaryString(32));
		System.out.println(BinaryCount.getMaxLength(32)); // Example usage, should print 5
		int[] A = {1, 2, 3}; // Example array
		// // Test the BinaryCount solution method [6, 3, 8, 9, 7] after 1 rotation
		// System.out.println(BinaryCount.solution(A, 5).toString());
		// System.out.println(BinaryCount.jumps(15, 75, 30));
	//  System.out.println(BinaryCount.PermMissingElem(new int[]{3, 2, 4, 5})); // Example usage for solution2
	// System.out.println(BinaryCount.solutionDice(new int[]{3, 2, 4, 5})); // Example usage for PermMissingElem
		// System.out.println(BinaryCount.solution2(new int[]{1, 2, 3}, 2)); // Example usage for solution2
		// System.out.println(BinaryCount.getMaxLength(15)); // Example usage for binary count
		// System.out.println(BinaryCount.getMaxLength(32)); // Example usage for binary count
	}

}
