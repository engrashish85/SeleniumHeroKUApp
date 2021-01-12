package Module1;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Set_Practice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Creating an object of HashSet and allocating memory to it
		Set <Integer> hash_set = new HashSet<Integer> ();
		
		//Adding elements in HashSet
		hash_set.add(1);
		hash_set.add(2);
		hash_set.add(3);
		hash_set.add(3);
		hash_set.add(190);
		
		//Printing hash_set
		System.out.println("Retrieving output without the duplicates");
		System.out.println(hash_set);
		
		//Creating an object with the treeset
		Set <Integer> tree_set = new TreeSet <Integer> (hash_set);
		System.out.println("TreeSet is - "+tree_set);
		
		//Testing Union, Intersection and Difference
		Set <Integer> a = new HashSet <Integer>();
		a.addAll(Arrays.asList(new Integer[] {1,1,2,3,4,2,5}));
		System.out.println(a);
		
		Set <Integer> b = new HashSet <Integer>();
		b.addAll(Arrays.asList(new Integer[] {1,6,7,8,8,9,2}));
		System.out.println(b);
		
		//Retrieving union
		Set<Integer> Union = new HashSet <Integer> (a);
		
		//Adding 2 sets
		Union.addAll(b);
		
		//Retrieving the 2 sets and printing in console
		System.out.println("Union of the 2 sets is - "+Union);
		
		//Retrieving Intersection
		Set<Integer> Intersection = new HashSet <Integer> (a);
				
		//Adding 2 sets
		Intersection.retainAll(b);
				
		//Retrieving the 2 sets and printing in console
		System.out.println("Intersection of the 2 sets is - "+Intersection);
		
		//Retrieving Intersection
		Set<Integer> Difference = new HashSet <Integer> (a);
				
		//Adding 2 sets
		Difference.removeAll(b);
				
		//Retrieving the 2 sets and printing in console
		System.out.println("Difference of the 2 sets is - "+Difference);

	}
}																																																																																																																																																																																																																																																																																																																																																															