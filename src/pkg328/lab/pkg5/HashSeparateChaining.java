package pkg328.lab.pkg5;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Brett
 */
public class HashSeparateChaining {

    private int sizeOfTable = 0, sizeOfList = 0;
    private Scanner input = new Scanner(System.in);

    /**
     * Set the size of the hash table
     */
    public void setTableSize() {
	//get size of TABLE
	System.out.println("What size table do you want? ");
	sizeOfTable = input.nextInt();
    }

    /**
     * @return the size of the table
     */
    public int getTableSize() {
	return sizeOfTable;
    }

    /**
     * Set the size of the list
     */
    public void setListSize() {
	do {
	    System.out.println("How Many numbers would you like in your table? ");
	    sizeOfList = input.nextInt();
	    if (sizeOfList > 100 || sizeOfList <= 0) {
		System.out.println("Sorry, enter a number between 1 and 100");
	    }
	} while (sizeOfList > 100 || sizeOfList <= 0);
    }

    /**
     * @return the size of the list
     */
    public int getListSize() {
	return sizeOfList;
    }

    /**
     * Creates a list to the size specified by the user
     *
     * @param arr - array to be trimmed
     * @return shuffled list of size determined by user
     */
    public ArrayList<Integer> createList(ArrayList<Integer> arr) {
	arr.subList(sizeOfList, arr.size()).clear();
	arr.trimToSize();
	return arr;
    }

    /**
     * Populate the Hash Table
     *
     * @param hashTable
     * @param arr
     * @return
     */
    public ArrayList<LinkedList> populateHashTable(ArrayList<LinkedList> hashTable,
	    ArrayList<Integer> arr) {
	//initialize table with empty ArrayLists
	for (int j = 0; j < sizeOfTable; j++) {
	    hashTable.add(new LinkedList());
	}

	for (int i = 0; i < sizeOfList; i++) {
	    hashTable.get(arr.get(i) % sizeOfTable).add(arr.get(i));
	    //           returns LINKED LIST        adds NODE to LINKED LIST
	}
	return hashTable;
    }
    
    /**
     * Searches for a number given by the user
     *
     * @param hashTable - table to be searched
     * @param key - number that is being searched for
     * @return whether or not the number was found
     */
    public boolean searchForKey(ArrayList<LinkedList> hashTable, int key) {
	return hashTable.get(key % 10).contains(key);
    }

}
