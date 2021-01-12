package Module1;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;

public class Deque_Practice {

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		
		//Instantiating ArrayDeque deque
		Deque <String> deque = new ArrayDeque <String> ();
		
		//Adding elements to deque
		deque.addFirst("A");
		deque.add("B");
		
		//Instantiating array
		ArrayList<String> a = new ArrayList <String> ();
		a.add("a");
		a.add("b");
		a.add("c");
		a.add("d");
		
		//Addall in deque
		deque.addAll(a);
		
		//Adding last element in deque
		deque.addLast("Z");
		
		//Retrieving first and last elements of deque
		String firstElement = deque.getFirst();
		String lastElement = deque.getLast();
		System.out.println("First element is - "+firstElement+ " Last element is - "+lastElement);
		
		//Printing deque
		System.out.println(deque);
		
		//Adding elements using offer method
		deque.offer("E");
		deque.offerFirst("F");
		deque.offerLast("H");
		
		//Printing deque
		System.out.println(deque);
		
		//Retaining only the arraylist
		deque.retainAll(a);
		System.out.println(deque);
		
		//Peek in deque
		System.out.println("peek first - "+deque.peekFirst());
		System.out.println("deque peek first -"+deque);
		System.out.println("peek last - "+deque.peekLast());
		System.out.println("deque peek last - "+deque);
		
		//Adding arraylist
		deque.addAll(a);
		System.out.println("Finally after adding arraylist again - " +deque);
		
		//Using pop in java
		deque.pop();
		System.out.println("After pop - "+deque);
		
		//Deque iterator
		for (@SuppressWarnings("rawtypes")
		Iterator aIerator = deque.iterator();aIerator.hasNext();) {
			System.out.println(aIerator.next());
		}
		
		//Using while loop
		@SuppressWarnings("rawtypes")
		Iterator aIterator = deque.iterator();
		while (aIterator.hasNext()) {
			System.out.println(aIterator.next());
		}		
	}
}
