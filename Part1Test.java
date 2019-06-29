//
// Part1.java							Author: Debra Ragland 					Assignment 7 CSPC50100
//
// Program designed to compute the greatest common divisor between two positive integers. 


import java.util.*;

public class Part1Test {

	private static int gcd(int num1, int num2) throws EqualsOneException {
		if (num2 == 0)
			return num1;
		else
			return gcd(num2, num1 % num2);
	}//Compute GCD recursively. 

	public static void main(String[] args) {
		try (Scanner scan = new Scanner(System.in)) {
			System.out.println("Please enter the first positive integer: ");
			int num1 = scan.nextInt();

			System.out.println("Please enter the second positive integer: ");//prompt the user to input integers.
			int num2 = scan.nextInt();

			int gcd = gcd(num1, num2);

			if (gcd(num1, num2) == 1) {
				throw new EqualsOneException("The GCD is 1.");// if GCD=1 throw exception. 
			} else if (gcd(num1, num2) < 0) {
				throw new IllegalArgumentException("Please be sure to only enter positive integers.");
			} else {
				System.out.println(
						"The greatest common divisor for these numbers, according to Euclid's Algorithm, is: " + gcd);
			}//if user inputs negative numbers throw exception.
		} catch(EqualsOneException | IllegalArgumentException e) 
		{
			System.out.println(e.getMessage());
		}//cover default exception format with exception message. 

	}

}
