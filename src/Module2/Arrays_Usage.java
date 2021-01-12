package Module2;

import java.util.Arrays;

public class Arrays_Usage {

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		
		//Array to store user names
		int i = 0;
		String[] arrUsername = new String [5];
		while (i<5) {
			arrUsername [i] = "Username" + (i+1);
			i = i + 1;
		}
		System.out.println("Length of the string is - "+arrUsername.length);
		
		//Printing elements of an array in descending order
		for (int j = arrUsername.length - 1; j >= 0; j --) {
			System.out.println("Value of the element located at " + j + " position is - "+arrUsername [j]);
		}
		
		Arrays_Usage obArrays_Usage = new Arrays_Usage ();
		obArrays_Usage.arraysort();
		
	}
	
	public void arraysort () {
		
		String[] names = {"ankit","ashish","akanksha","pavneet","gursimran"};
		Arrays.sort(names, 0, 4);
		System.out.println("modified array is - "+Arrays.toString(names));
		
	}

}
