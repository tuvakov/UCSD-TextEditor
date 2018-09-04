package my.examples;

public class ListNode<E> {

	ListNode<E> prev;
	ListNode<E> next;
	private E data;
	
	public ListNode(E theData){
		data = theData;
	}
	
	
	@Override
	public String toString(){
		return "" + data;
	}
}
