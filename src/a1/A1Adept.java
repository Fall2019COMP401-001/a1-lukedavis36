package a1;

import java.util.Scanner;

public class A1Adept {

	public static void main(String[] args) {
		
	//Input:
		// integer count of number of items in the store
		// for each item:
			// name of item
			// price of item
		//integer count of number of customers
		// for each customer:
			// first name
			// last name
		// integer count of number of items the customer bought
		// for each of the items bought:
			// quantity of the item bought 
			// name of the item
	// Output:
		// Biggest: FIRST LAST (AMOUNT)
		// Smallest: FIRST LAST (AMOUNT)
		// Average: AVERAGE
	
	
	
	// Create scanner and find number of items
	Scanner sc = new Scanner(System.in);
	int numberOfItems = sc.nextInt();
	
	// Initialize itemNames and itemPrices arrays
	String[] itemNames = new String[numberOfItems];
	double[] itemPrices = new double[numberOfItems];
	
	// Fill itemNames and itemPrices arrays
	for (int i=0; i < numberOfItems; i++) {
		
		itemNames[i] = sc.next();
		itemPrices[i] = sc.nextDouble();
	}
	
	// Find number of customers
	int numberOfCustomers = sc.nextInt();
	
	// Create firstName, lastName, and amountSpent arrays
	String[] firstNames = new String[numberOfCustomers];
	String[] lastNames = new String[numberOfCustomers];
	double[] amountSpent = new double[numberOfCustomers];
	
	// For each customer:
	for (int i=0; i<numberOfCustomers; i++ ) {
		
		// find their names
		firstNames[i] = sc.next();
		lastNames[i] = sc.next();
		
		// find their number of unique items bought
		int uniqueItemsBought = sc.nextInt();
		
		// For each unique item:
		for (int j=0; j<uniqueItemsBought; j++) {
			
			// find quantity of that item, index of that item in the String array, and price of the item
			int quantityOfItem = sc.nextInt();
			int itemIndex = indexOfItem(itemNames, sc.next());
			double priceOfItem = itemPrices[itemIndex];
			
			// add product of the quantity of item and price of item to the amountSpent array
			amountSpent[i] += ((double) quantityOfItem) * priceOfItem;
			
		}
	
		
	}
	
	// get the max and min indices with the defined static methods
	int maxIndex = indexOfMostSpent(amountSpent);
	int minIndex = indexOfLeastSpent(amountSpent);
	
	// calculate the average with the defined static method
	double average = calculateAverage(amountSpent);
	
	// Print out results in proper format
	System.out.println("Biggest: " + firstNames[maxIndex] + " " + lastNames[maxIndex] + " (" + amountSpent[maxIndex] + ")");
	System.out.println("Smallest: " + firstNames[minIndex] + " " + lastNames[minIndex] + " (" + amountSpent[minIndex] + ")");
	System.out.println("Average: " + String.format("%.2f", average -.005));
		

}
// END MAIN METHOD


	
	
	

// HELPER METHODS 

// Find index of String in String array
public static int indexOfItem(String[] names, String itemName) {
	
	int index = 0;
	
	for (int i=0; i<names.length; i++) {
		if (names[i].contentEquals(itemName)) {
			index = i;
			break;
		}
	}
	return index;
}


// Find index of the highest amountSpent
public static int indexOfMostSpent(double[] amountsSpent) {
	int index = 0;
	double maxValue = 0.0;
	
	for (int i=0; i<amountsSpent.length; i++) {
		
		if (amountsSpent[i] > maxValue) {
			maxValue = amountsSpent[i];
			index = i;
		}
	}
	return index;
}


// Find index of the least amountSpent
public static int indexOfLeastSpent(double[] amountSpent) {
	int index = 0;
	double minValue = amountSpent[0];
	
	for (int i=1; i<amountSpent.length; i++) {
		if (amountSpent[i]< minValue) {
			minValue = amountSpent[i];
			index = i;
		}
	}
	return index;
}


// calculate the average of the amountSpent array
public static double calculateAverage(double[] amountSpent) {
	double total = 0;
	
	for (int i=0; i<amountSpent.length; i++) {
		total += amountSpent[i];
	}
	
	double average = total / ((double) amountSpent.length);
	return average;
}

}