package Module1;

public class Arrays_Practice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//1st way of working with arrays
		int intArray[];
		intArray = new int[5];
		for (int i=0; i<5; i++){
			System.out.println(intArray[i]);
		}
		
		//2nd way of working with arrays
		String[][] stringArray = new String[][] { {"a","b","c","d"},{"1","2","3","4"} };
		for (int i=0; i<2; i++){
			for (int j=0; j<4; j++){
				System.out.println("Array value in chronological order - "+stringArray[i][j]);
			}
		}	
		
		//Returning class variables through array
		Student[] arrayStudent = new Student[5];
		arrayStudent[0] = new Student(1, "a");
		arrayStudent[1] = new Student(2, "b");
		arrayStudent[2] = new Student(3, "c");
		arrayStudent[3] = new Student(4, "d");
		arrayStudent[4] = new Student(5, "e");
		
		for (int i=0; i<arrayStudent.length; i++){
			System.out.println(arrayStudent[i].rollNumber+ " "+arrayStudent[i].studentName);
		}
		
		//Return array from method
		int[] returnArrayFromMethod = m1();
		for (int i=0; i<returnArrayFromMethod.length; i++){
			System.out.println("Array value in chronological order - "+returnArrayFromMethod[i]);
		}
		
		//Cloning of arrays	    
		int[] mainArray = {1,2,3,4};
		int cloneArray[] = mainArray.clone();
		System.out.println(mainArray == cloneArray);
		for (int i=0; i<cloneArray.length; i++){
			System.out.println(cloneArray[i] + " ");
		}
		
		//Jagged arrays in Java
		int rows= 5;
		System.out.println("Jagged arrays in Java");
		int jaggedArray[][] = new int[rows][];
		for (int i = 0; i < jaggedArray.length; i++) {
			jaggedArray [i] = new int [i+1];
		}
		
		//Defining array with values
		int count = 0;
		for (int i = 0; i < jaggedArray.length; i ++){
			for (int j = 0; j < jaggedArray [i].length; j++) {
				jaggedArray [i][j] = count ++;
			}
		}
		
		//Displaying the contents of jagged array
		System.out.println("Displaying contents of 2D Jagged Array");
		for (int i = 0; i < jaggedArray.length; i ++){
			for (int j = 0; j < jaggedArray [i].length; j++) {
				System.out.print(jaggedArray [i][j] + "	");
			}
			System.out.println();
		}
	}
	
	public static int[] m1() {
		return new int[] {1,2,3};
	}
	
}

