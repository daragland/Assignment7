//
//Part2.java 						Author: Debra Ragland					Assignment 7 CPSC50100
//
// Program designed to allow user to add characters to a queue using a linked list format. 

import java.util.*;

public class Part2 {

	public static final int MAX_LENGTH = 10;
	public static String str;
	public static Scanner scan = new Scanner(System.in);
	public static Queue<Character> queue = new LinkedList<Character>(); // set up variables to be used in program.

	public static void main(String[] args) {
		try {
			System.out.print("Enter string, you can only add 10 characters at a time: ");
			str = scan.nextLine();

			for (int i = 0; i < str.length(); i++) 
			{
				queue.add(str.charAt(i));
			} //prompt user to input character string and store it in queue. 
			
			if (str.length() > MAX_LENGTH)
			{
				throw new EqualsOneException(
						"Error! Queue Overflow. There can only be 10 items in the queue at a time");
			} //if user input character string is too long throw error. 

			if (str.length() == 0) 
			{
				throw new RuntimeException("Error! Queue underflow. There are no items in the queue.");
			} // if user does not add anything to the queue, throw exception. 

			System.out.println("The queue contains" + queue);//if user input is 10 characters or less, show them what's in the queue. 
		} catch (EqualsOneException e) {
			System.out.println(e.getMessage());
			System.out.print("Would you like to remove the head of the queue to make space for new characters? (y/n):");
			str = scan.nextLine();
			if (str.equalsIgnoreCase("y")) 
			{
				while (queue.size() > MAX_LENGTH) 
				{
					char removedele = queue.remove();
					System.out.println("Removed element: " + removedele);
				}
				System.out.println("The queue contains; " + queue);
			}//catch user input over 10 characters, show them the error and prompt them to remove characters from the head of the queue. 

		} catch (RuntimeException e) {
			System.out.println(e.getMessage());
			System.out.print("Would you like to add new characters to the queue? (y/n):");
			str = scan.nextLine();
			if (str.equalsIgnoreCase("y")) 
			{
				System.out.print("Enter String, you can only add 10 characters at a time: ");
				str = scan.nextLine();
				for (int i = 0; i < str.length(); i++) 
				{
					queue.add(str.charAt(i));
					
				} if (str.length() < MAX_LENGTH)
					System.out.println("The queue contains: " + queue);
			 
			while (str.length() > MAX_LENGTH) 
			{
					try {
						throw new EqualsOneException("***Error: Character String too long.***");
					} catch (EqualsOneException m) {
						System.out.println(m.getMessage());
						System.out.print("Would you like to remove the head of the queue to make space for new characters? (y/n):");
						str = scan.nextLine();
						if (str.equalsIgnoreCase("y")) 
						{
							while (queue.size() > MAX_LENGTH) 
							{
								char removedele = queue.remove();
								System.out.println("Removed element: " + removedele);
							}
							System.out.println("The queue contains; " + queue);
						}// Catch empty queue, prompt user to input characters, if string > 10 characters repeat the same steps
						//in the first try/catch block. If character string is < 10 characters show items in the queue. 
					}
				}
			}
			}
		}
	}

