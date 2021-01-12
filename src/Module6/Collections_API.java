package Module6;

import java.util.ArrayList;
import java.util.Hashtable;

public class Collections_API {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> list = new ArrayList<String> ();
		list.add("A");
		list.add("B");
		list.add("C");
		list.add("D");
		
		System.out.println(list.get(2));
		System.out.println(list.size());
		
		for (int i=0; i<list.size(); i++)
		{
			System.out.println(list.get(i));
		}
		
		//**************************HashTable********************
		Hashtable<String, String> table = new Hashtable<String, String>();
		table.put("Name", "Ashish");
		table.put("place", "Australia");
		System.out.println(table.get("Name"));
		System.out.println(table.get("place"));
		table.put("place", "India");
		System.out.println(table.get("place"));
	}
	
}
