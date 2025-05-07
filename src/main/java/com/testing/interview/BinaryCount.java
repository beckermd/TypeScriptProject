package com.testing.interview;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class BinaryCount {

    public static int getMaxLength(int value) {
        // String binaryString = Integer.toBinaryString(value);
        // String[] binarySplit = binaryString.split("1");
        // List<String> binarySplitsWo = Arrays.stream(binarySplit).filter(t -> !t.isEmpty()).collect(Collectors.toList());
        // int maxLength = 0;
        // if (binarySplitsWo.size() == 0) {
        //     return maxLength; // In case of 0, it will return 0 as there are no 1's in binary
        // }
        // if (binaryString.endsWith("0")) {
        //     binarySplitsWo.remove(binarySplitsWo.size() - 1);
        //     if (binarySplitsWo.size() > 1) {
        //         return maxLength; // In case of all 1's, it will return 0
        //     } else {
        //         return countRepetitions(binarySplitsWo, maxLength);
        //     }
        // } else {
        //     return countRepetitions(binarySplitsWo, maxLength);
        // }

            String binaryString = Integer.toBinaryString(value);
            String[] binarySplit = binaryString.split("1");
            int maxLength = 0;
            if (binarySplit.length == 0) {
                return maxLength; // In case of 0, it will return 0 as there are no 1's in binary
            }
            if (binaryString.endsWith("0")) {
                        binarySplit[binarySplit.length - 1] = ""; // Remove the last empty part
                
                if (binarySplit.length > 1) {
                    return maxLength; // In case of all 1's, it will return 0
                } else {
                    return countRepetitions(binarySplit, maxLength);
                }
            } else {
                return countRepetitions(binarySplit, maxLength);
            }
        }


    private static int countRepetitions(String[] binarySplit, int maxLength) {
        for (String binaryPart : binarySplit) {
            // We count the length of 0's between 1's
            if (binaryPart.length() > maxLength) {
                maxLength = binaryPart.length();
            }
        }
        return maxLength;
    }

    public static String solution(int[] A, int k) {
        k = k % A.length; // Adjust k to avoid unnecessary rotations
        int[] B = new int[A.length];
        for (int i = 0; i < k; i++) {
            // Create a copy of the array to avoid modifying original
            B[0] = A[A.length - 1];
            for (int j = 1; j <= A.length - 1; j++) {
                // Last element, no next element to copy from
                B[j] = A[j - 1];
            }
            // Now copy B back to A for the next iteration
            for (int j = 0; j < A.length; j++) {
                A[j] = B[j];
            }
        }
        return Arrays.toString(B);
    }

    public static String solution2(int[] A, int k) {
        k = k % A.length; // Adjust k to avoid unnecessary rotations
        int[] B = new int[A.length];
        for (int i = 0; i < k; i++) {
            // Create a copy of the array to avoid modifying original
            B[0] = A[A.length - 1];
            for (int j = 1; j <= A.length - 1; j++) {
                // Last element, no next element to copy from
                B[j] = A[j - 1];
            }
            // Now copy B back to A for the next iteration
            for (int j = 0; j < A.length; j++) {
                A[j] = B[j];
            }
        }
        return Arrays.toString(B);
    }

    public static int jumps(int X, int Y, int D) {
        int length = Y - X;
        if (length <= 0) {
            return 0; // No jumps needed if Y is less than or equal to X
        } else {
            System.out.println("X: " + X);
            System.out.println("Y: " + Y);
            System.out.println("D: " + D);
            System.out.println("Length: " + length);
            System.out.println("Length: " + length / D);
            return length % D == 0 ? length / D : length / D + 1; // Calculate the number of jumps needed
        }
    }
    public static int PermMissingElem(int[] A){
        int N = A.length;
        // The expected sum of the first N+1 natural numbers
        int expectedSum = (N + 1) * (N + 2) / 2;
        // The actual sum of the elements in the array
        int actualSum = 0;
        for (int i : A) {
            actualSum += i;
        }
        // The missing element is the difference between the expected and actual sums
        return expectedSum - actualSum;
    }

    public static int TapeEquilibrium (int[] A){
        int N = A.length;
        if (N < 2) {
            return 0; // No equilibrium possible with less than 2 elements
        }
        // Calculate the total sum of the array
        int totalSum = 0;
        for (int i : A) {
            totalSum += i;
        }
        int leftSum = 0;
        int minDifference = Integer.MAX_VALUE; // Initialize to max value to find the minimum
        for (int P = 1; P < N; P++) { // P is the partition point, it should be at least 1 to N-1
            leftSum += A[P - 1]; // Sum of the left part
            int rightSum = totalSum - leftSum; // Sum of the right part
            int difference = Math.abs(leftSum - rightSum); // Calculate the difference
            if (difference < minDifference) {
                minDifference = difference; // Update the minimum difference
            }
        }
        // The missing element is the difference between the expected and actual sums
        return minDifference;
    }


    public static int passingCars(int[] A) {
        int sum = 0;
        int noEastSoFar = 0;
        boolean exceed = false;
        for (int i = 0; i < A.length; i++) {
            if (A[i] == 0) noEastSoFar++;
            else sum += noEastSoFar;
            if (sum > 1000000000) exceed = true;
        }
        return exceed == true? -1 : sum;
    }

    // public static int module(int A, int B, int K) {
    //     int range = B-A;
    //     if(range < 0) {
    //         return 0; // No valid range
    //     }
    //     if(range%K==0 && (A%K==0 || B%K==0)) {
    //         return (range/K)+1; // Both A and B are divisible by K
    //     } else if(range%K!=0 && B%K==0){
    //         return (range%K)-1; // B is divisible by K, A is not
    //     } 
    //     else if(range%K==0 && A%K!=0) {
    //         return range/K; // Only B is divisible by K
    //     } else {
    //         return range%K; // Normal case, return the quotient
    //     }
    // }

    public static int module(int A, int B, int K) {
        int range = B - A;
        if (range < 0) {
            return 0; // No valid range
        }
        // Calculate the number of multiples of K in the range [A, B]
        int count = (B / K) - ((A - 1) / K);
        return count;
    }

    public static int solutionDice(int[] A){
        int N= A.length;
        int position = 0;
        int sum = A[0];
        while (position < N-1) {
        int dice= new Random().nextInt(6) + 1; // Simulate a dice roll (1-6)
            position += dice; // Move the position by the dice roll
            if (position >= N) {
                return sum; // Reached or passed the end of the array
            } else {
                sum += A[position]; // Add the value at the new position to the sum
            }  
        }
        return sum; // Return the final sum when reaching the end of the array
    }

}
