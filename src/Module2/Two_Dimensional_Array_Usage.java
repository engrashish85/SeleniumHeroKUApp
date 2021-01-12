package Module2;

public class Two_Dimensional_Array_Usage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Initializing 2 dimensional array
		String[][] arrTwoDimensional = new String [3][4];
		
		//Initializing i = 0;
		int i = 0;
		int j = 0;
		
		while (i < 3) {
			for (j = 0; j < 4; j ++) {
				arrTwoDimensional [i][j] = "UserName" +i+j;
				System.out.println("Value located at "+i+"th row and "+j+ "th column is - "+ arrTwoDimensional[i][j]);
			}
			i = i + 1;
		}
		
		//Retrieving the length of an array
		int arrRowLength = arrTwoDimensional.length;
		int arrColumnLength = arrTwoDimensional[0].length;
		System.out.println("Length of array rows is - " +arrRowLength);
		System.out.println("Length of array columns is - " +arrColumnLength);
	
		//Printing array in a presentation order
		for (i = arrRowLength - 1; i >= 0; i --) {
			for (j = 0; j < arrColumnLength; j++) {
				System.out.print(arrTwoDimensional[i][j] + "--");
			}
			System.out.println();
		}
	}
}

