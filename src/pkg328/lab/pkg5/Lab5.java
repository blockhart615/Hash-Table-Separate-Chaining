package pkg328.lab.pkg5;

import java.util.Collections;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Brett
 */
public class Lab5 {

    public static void main(String[] args) {
//	DECLARATIONS:
	ArrayList<Integer> arr = new ArrayList();
	ArrayList<LinkedList> hashTable = new ArrayList();
	HashSeparateChaining hasher = new HashSeparateChaining();
	Scanner input = new Scanner(System.in);
	int n = 100;
	double loadFactor = 0;

//	Create 100 distinct integers and shuffle
	for (int i = 0; i < n; i++) {
	    arr.add(i + 1);
	}
	Collections.shuffle(arr);

//	set size of the table and the list
	hasher.setTableSize();
	hasher.setListSize();

//	create list of size m
	arr = hasher.createList(arr);

//	populate hashTable with the hash table
	hashTable = hasher.populateHashTable(hashTable, arr);

//	Display the hash table
	System.out.println("\n");
	for (int i = 0; i < hashTable.size(); i++) {
	    System.out.print("Index: " + i + "|   ");
	    if (hashTable.get(i).isEmpty()) {
		System.out.print("Empty");
	    } else {
		for (int j = 0; j < hashTable.get(i).size(); j++) {
		    System.out.print(hashTable.get(i).get(j) + "  ");
		}
	    }

	    loadFactor += hashTable.get(i).size();
	    System.out.println();
	}

//	Calculate and display Load Factor
	loadFactor = loadFactor / (double) hasher.getTableSize();
	System.out.println("The Load Factor is: " + loadFactor + ".\n");

//	LOOPING SECTION SEARCHES FOR KEY DEFINED BY THE USER
	boolean searchForKey = true;
	do {
	    System.out.println("What would you like to do?"
		    + "\n\t1) Search for a number"
		    + "\n\t2) Exit Program");
//	    If user presses 1, search for key
	    if (input.nextInt() == 1) {
		System.out.println("Which number would you like to search for?");
		int key = input.nextInt();
//		Display the results
		if (hasher.searchForKey(hashTable, key)) {
		    System.out.println(key + " was successfully found!");
		} else {
		    System.out.println(key + " was NOT found.");
		}
//	    If user presses anything else, exit program
	    } else {
		searchForKey = false;
	    }
	} while (searchForKey);

	System.out.println("\nExiting Program.");

    }
}
