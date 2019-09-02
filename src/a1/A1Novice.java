package a1;

import java.util.Scanner;

public class A1Novice {

	public static void main(String[] args) {
		
		// First Input: integer indicating total number of customers
		// For each customer: First Name, Last name, number of items bought by the customer, 
		// For each item bought: input will contain: integer quantity of the item bought, name of item (single word), price as double
		
		//Output: First name First initial (F), Last Name, Total cost (to two decimal places)
		
		
		// Create scanner and find number of customers
		Scanner sc = new Scanner(System.in);
		int numberOfCustomers = sc.nextInt();
		
		
		// Initialize arrays for First Name, Last Name, and Total Cost
		String[] firstNames = new String[numberOfCustomers];
		String[] lastNames = new String[numberOfCustomers];
		double[] totalCost = new double[numberOfCustomers];
		
		// For each customer
		for (int i=0; i<numberOfCustomers; i++) {
			
			// Record their name (first and last)
			firstNames[i] = sc.next();
			lastNames[i] = sc.next();
			
			// Find how many items they bought
			int numberOfItems = sc.nextInt();
			
			// For each item
			for (int j=0; j<numberOfItems; j++) {
				
				// find quantity of the item, the item name, and the price of the item
				int quantity = sc.nextInt();
				String item = sc.next();
				double price = sc.nextDouble();
				
				// multiply quantity of item by price of item, and add that value to totalCost array
				totalCost[i] +=  ((double) quantity) * price;
					
				
			}
			
			// Print out the information in the proper format
			System.out.println(firstNames[i].charAt(0) + ". " + lastNames[i] + ": " +
								String.format("%.2f", totalCost[i]));
		}		
	}
}