package Module1;

public class LinkedList {
	Node head;
	
	static class Node {
		int data;
		Node next;
		
		//Constructor
		Node (int d) { 
			data = d;
			next = null;
			}
	}
	
	public static LinkedList LinkedListInsert (LinkedList list, int data) {
		Node new_node = new Node (data);
		new_node.next = null;
		
		if (list.head == null) {
			list.head = new_node;
		}
		
		else {
			Node last = list.head;
			while(last.next != null) {
				last = last.next;
			}
			
			last.next = new_node;
		}
		
		return list;
	}
	
	public void printList (LinkedList list) {
		Node currNode = list.head;
		System.out.println("Linked List");
		
		while (currNode!= null) {
			System.out.println(currNode.data + "	");
			currNode = currNode.next;
		}
	}
}
