package a1;

import java.util.Scanner;

public class A1Jedi {

	public static void main(String[] args) {
		
		// Create scanner and find number of items
		Scanner sc = new Scanner(System.in);
		int numberOfItems = sc.nextInt();
		
		
		// Initialize itemName, quantityOfItemBought, numberOfCustomersWhoBought arrays
		String[] itemNames = new String[numberOfItems];
		int[] quantityOfItemBought = new int[numberOfItems];
		int[] numberOfCustomersWhoBought = new int[numberOfItems];
		
		
		// Item Prices.. won't actually use this but need to parse the input?
		double[] itemPrices = new double[numberOfItems];
		
		// For each item
		for (int i=0; i<numberOfItems; i++) {
			itemNames[i] = sc.next();
			itemPrices[i] = sc.nextDouble();
		}
		
		
		
		// get number of customers
		int numberOfCustomers = sc.nextInt();
		
		// for each customer
		for (int i=0; i<numberOfCustomers; i++) {
			
			// momentarily store the names (don't save anywhere)
			String firstName = sc.next();
			String lastName = sc.next();
			
			boolean[] customerHasBought = new boolean[numberOfItems];
			int lengthOfPurchaseList = sc.nextInt();
			
			// for each purchase in the list
			for (int j=0; j<lengthOfPurchaseList; j++) {
				
				int quantity = sc.nextInt();
				String itemName = sc.next();
				
				updateQuantityBought(quantity, itemName, quantityOfItemBought, itemNames);
				updateNumberOfCustomersWhoBought(customerHasBought, numberOfCustomersWhoBought, itemName, itemNames);
				
			}
			
		}
		
		for (int i=0; i<numberOfItems; i++) {
			
			if (quantityOfItemBought[i] == 0) {
				System.out.println("No customers bought " + itemNames[i]);
			}
			
			else {
				System.out.println(numberOfCustomersWhoBought[i] + " customers bought " +
									quantityOfItemBought[i] + " " + itemNames[i]);
			}
			
		}
		
		
	}
	
	
	
	public static void updateQuantityBought(int quantity, String itemName, int[] quantityOfItemBought, String[] itemNames) {
		
		int index = indexOfItem(itemNames, itemName);
		
		quantityOfItemBought[index] += quantity;
	}
	
	
	public static void updateNumberOfCustomersWhoBought(boolean[] customerHasBought, int[] numberOfCustomersWhoBought,
			String itemName, String[] itemNames) {
		
		int index = indexOfItem(itemNames, itemName);
		
		if (!customerHasBought[index]) {
			customerHasBought[index] = true;
			numberOfCustomersWhoBought[index] += 1;
		}
	}
	
	
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

}
