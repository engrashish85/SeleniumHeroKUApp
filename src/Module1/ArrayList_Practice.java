package Module1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class ArrayList_Practice {
	public static void main (String[] args) {
		
		//Initializing array list
		ArrayList<Integer> arrayList = new ArrayList <Integer> (5);
		for (int i = 0; i < 5; i ++) {
			
			//adding integers into list
			arrayList.add(i, (i+1)*(i+2));
		}
			
		//adding integers into list
		System.out.println(arrayList);
		
		//Removing number from the list
		//arrayList.remove(2);
		
		//adding integers into list
		System.out.println(arrayList);
		
		//Printing elements through get method
		for (int i = 0; i < arrayList.size(); i ++) {
			
			//adding integers into list
			System.out.print(arrayList.get(i) + "	");
			
		}
		
		//Retrieving elements using For Each loop
		System.out.println("Using for each loop");
		for (int i:arrayList) {
			System.out.println(i);
		}
		
		//Usage of contains
		if (arrayList.contains(20)) {
			System.out.println("operation successful");
		}
		else
		{
			System.out.println("operation unsuccessful");	
		}
		
		//Returning a sublist
		List<Integer> subArrayList = arrayList.subList(1, 4);
		System.out.println(subArrayList);
		System.out.println("Element present in a list at 1st position is - " +subArrayList.get(0));
		
		//ArrayList of ArrayList
		System.out.println("Executing nested array lists");
		int number = 4;
		ArrayList<ArrayList<Integer>> nestedArrayList = new ArrayList<ArrayList<Integer>> (number);
		
		//Creating sub array lists
		ArrayList <Integer> a1 = new ArrayList <Integer> ();
		for (int i = 0; i < number*2; i ++) {
			a1.add(number * (i+1));
		}
		System.out.println("size of a1 is - " + a1.size());
		
		ArrayList <Integer> a2 = new ArrayList <Integer> ();
		for (int i = 0; i < number*3; i ++) {
			a2.add(number + i);
		}
		
		ArrayList <Integer> a3 = new ArrayList <Integer> ();
		for (int i = 0; i < number*4; i ++) {
			a3.add(number - (i+2));
		}
		
		ArrayList <Integer> a4 = new ArrayList <Integer> ();
		for (int i = 0; i < number*5; i ++) {
			a4.add(number * (i+4));
		}
		
		System.out.println("retrieved all the arraylists");
		
		//Adding all the corresponding array lists into nested array list
		nestedArrayList.add(a1);
		nestedArrayList.add(a2);
		nestedArrayList.add(a3);
		nestedArrayList.add(a4);
		
		System.out.println("Nested all the arraylists having size "+ nestedArrayList.size());
		
		//Printing all the elements of nested arraylist
		for	(int i = 0; i < nestedArrayList.size(); i ++) {
			for (int j = 0; j < nestedArrayList.get(i).size(); j ++) {
				System.out.print(nestedArrayList.get(i).get(j) + "	");
			}
			System.out.println();
		}
		
		//Creating a string of combination of ASCII character values in sorted and reverse order
		int iASCIIReverse = 122;
		ArrayList <String> arrListASCII = new ArrayList <String> ();
		for (int iASCIIcount = 65; iASCIIcount <= 122; iASCIIcount ++) {
			String sASCII = String.valueOf((char)iASCIIReverse + String.valueOf((char)iASCIIcount));
			arrListASCII.add(sASCII);
			iASCIIReverse = iASCIIReverse - 1;
		}
		
		//Printing the elements of array list
		for (int i = 0; i <= arrListASCII.size() - 1; i ++) {
			System.out.println("The element at "+ i + " position is - "+arrListASCII.get(i));
		}
		
		//Printing elements in ascending order
		Collections.sort(arrListASCII, Collections.reverseOrder());
		
		//Printing elements in ascending order
		for (int i = 0; i <= arrListASCII.size() - 1; i ++) {
			System.out.println("The sorted element at "+ i + " position is - "+arrListASCII.get(i));
		}
		
		ArrayList_Practice obArrayListPractice = new ArrayList_Practice ();
		ArrayList<String> list1 = new ArrayList<String> ();
		list1.add("a");
		list1.add("a");
		list1.add("b");
		list1.add("b");
		list1.add("a");
		list1.add("a");
		list1.add("b");
		list1.add("b");
		obArrayListPractice.removeDuplicatesFromArrayList(list1);
		
	}

	public ArrayList <String> removeDuplicatesFromArrayList (ArrayList<String> list1) {
		
		// TODO Auto-generated method stub
		Set <String> set1 = new LinkedHashSet <> ();
		set1.addAll(list1);
		list1.clear();
		list1.addAll(set1);
		System.out.println("List is - "+list1);
		return list1;
		
	}
}
