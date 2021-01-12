package Module1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Hashmap_Practice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Declaring Hashmap
		HashMap <Integer, String> hashmap = new HashMap <Integer, String> ();
		
		//Putting the values in hashmap
		hashmap.put(1, "A");
		hashmap.put(2, "B");
		hashmap.put(3, "C");
		hashmap.put(4, "D");
		
		//Printing size
		System.out.println("Size of hashmap is - "+hashmap.size());
		
		//Printing entry set
		System.out.println("Entry set of hashmap is - "+hashmap.entrySet());
		
		//Printing hashmap
		System.out.println("Printing hashmap - "+hashmap);
		
		//Printing keys
		System.out.println("Printing keyset - "+hashmap.keySet());
		
		//Validating if th map contains value "B"
		if (hashmap.containsKey(2)) {
			int a = hashmap.hashCode();
			String b = hashmap.get(2);
			System.out.println("Hashcode is - "+a+ " value contained in 2nd key is - "+b);
		}
		
		//Copying values from hashmap to hashmap1
		HashMap <Integer, String> hashmap1 = new HashMap <Integer, String> ();
		hashmap1.putAll(hashmap);
		
		//Displaying values in hashmap1
		System.out.println("Printing hashmap1 - " +hashmap1);
		
		//Printing collection values of hashmap1
		hashmap1.put(1, "E");
		
		System.out.println(hashmap1);
		
		//clearing map
		hashmap.clear();
		
		//Clearing hashmap1
		hashmap1.clear();
				
		System.out.println(hashmap);
		
		if (hashmap.isEmpty()) {
			System.out.println("hashmap us empty is");
		}
		else {
			System.out.println(hashmap.entrySet());
		}
		
		int arr[] = {10, 34, 5, 5, 1, 1, 2, 2, 3, 3, 3};
		Hashmap_Practice hashmapPractice = new Hashmap_Practice();
		hashmapPractice.printFrequencyOfElements(arr);
		
		//Declaring a Hashmap
		HashMap <String, Integer> map1 = new HashMap <String, Integer>();
		
		//Sorting Hashmap in ascending order
		map1.put("D", 5);
		map1.put("C", 7);
		map1.put("B", 2);
		map1.put("A", 1);
		
		ArrayList <String> a = hashmapPractice.sortHashMapKeysInAscendingOrder(map1);
		System.out.println("sorted array list is - "+a);
		
		//Putting keys into array list
		ArrayList<Integer> list1 = new ArrayList <Integer> ();
		
		//Printing hashmap values on the basis of the sorted keys
		for (int i = 0; i < a.size(); i ++) {
			int tempInteger = map1.get(a.get(i));
			System.out.println(i + " integer is - "+tempInteger);
			list1.add(i, map1.get(a.get(i)));
		}
	}
	
	//Function to sort hashmap in ascending order
	public ArrayList<Integer> sortHashMapValuesInAscendingOrder (HashMap<String, Integer> map1) {
		ArrayList <Integer> sortedValues = new ArrayList <> (map1.values());
		Collections.sort(sortedValues);
		return sortedValues;	
	}
	
	//Function to sort hashmap in ascending order
	public ArrayList<String> sortHashMapKeysInAscendingOrder (HashMap<String, Integer> map1) {
		ArrayList <String> sortedValues = new ArrayList <> (map1.keySet());
		Collections.sort(sortedValues);
		return sortedValues;	
	}
	
	public void printFrequencyOfElements (int arr[]) {
		
		//Creating an Empty HashMap
		HashMap <Integer, Integer> hashmap = new HashMap <Integer, Integer> ();
		
		//Traversing through the array
		for (int i = 0; i < arr.length; i++) {
			
			//Retrieving the value of an array
			Integer c = hashmap.get(arr[i]);
			System.out.println("Integer c is - "+c);
			
			if (hashmap.get(arr[i]) == null) {
				hashmap.put(arr[i], 1);
				System.out.println("Iteration "+i+" result hashmap is - "+hashmap);
			}
			else {
				hashmap.put(arr[i], ++c);
				System.out.println("Iteration "+i+" result hashmap is - "+hashmap);
				System.out.println("Counter at "+i+ "th iteration is - "+c);
			}
			
		}
		
		//Printing hashmap
		System.out.println(hashmap);
		
		//Printing entry set
		for (Integer currentKey : hashmap.keySet())	{
			System.out.println("Frequency of - "+currentKey+" is -"+hashmap.get(currentKey));
		}
			
	}
}
