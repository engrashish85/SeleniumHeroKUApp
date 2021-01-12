package Module7;

public class String_Functions {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a = "Time will come soon";
		String b = "Time will come soon";
		System.out.println("The length of string is - "+a.length());
		System.out.println("Character at 8th position is - "+a.charAt(5));
		System.out.println("Index of the first occurence of l is -"+a.indexOf("l"));
		System.out.println("Index of the second occurence of l is -"+a.indexOf("l", 8));
		System.out.println("Index of hello is - "+ a.indexOf("Hello"));
		System.out.println(a.equals(b));
		System.out.println(a.substring(0, a.indexOf("l")));
		String temp[] = a.split(" ");
		for (int i=0;i<temp.length;i++)
		{
			System.out.println(temp[i]);
		}
		
		//Convert datatypes
		String x = "100";
		int y = Integer.parseInt(x);
		System.out.println(y);
		String z = String.valueOf(y);
		System.out.println(z);
		
	}

}
