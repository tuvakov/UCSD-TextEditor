package my.examples;

public class MyLinkedList<E> {

	ListNode<E> head;
	private ListNode<E> tail;
	private int size;
	
	public MyLinkedList(){
		
		size = 0;
		head = new ListNode<E>(null);
		tail = new ListNode<E>(null);
		
		head.next = tail;
		tail.prev = head;
	}
	
	
	public void addFront(E data){
		
		ListNode<E> temp = new ListNode<E>(data);
		
		temp.next = head.next;
		temp.prev = head.next.prev;
		
		head.next.prev = temp;
		head.next = temp;
		
		//temp.next.prev = temp;
		//temp.prev.next = temp;
		 
		size++;
	}
	
	public int size(){
		return size;
	}
}
