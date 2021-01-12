package Module6;

import java.util.Hashtable;

public class HashTable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Hashtable <String, String> table1 = new Hashtable<String, String>();
		table1.put("city1", "FA");
		table1.put("city2", "LA");
		table1.put("city3", "SA");
				
		Hashtable <String, String> table2 = new Hashtable<String, String>();
		table2.put("city1", "1111");
		table2.put("city2", "2222");
		table2.put("city3", "4444");
		
		Hashtable<String, Hashtable <String, String>> table3 = new Hashtable<String, Hashtable <String, String>>();
		table3.put ("city", table1);
		table3.put ("zip", table2);
		System.out.println(table3.get("city").get("city2"));
		
		
	}

}
