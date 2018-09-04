package textgen;

import java.util.AbstractList;


/** A class that implements a doubly linked list
 * 
 * @author UC San Diego Intermediate Programming MOOC team
 *
 * @param <E> The type of the elements stored in the list
 */
public class MyLinkedList<E> extends AbstractList<E> {
	LLNode<E> head;
	LLNode<E> tail;
	int size;

	/** Create a new empty LinkedList */
	public MyLinkedList() {
		// TODO: Implement this method
		size = 0;
		
		head = new LLNode<E>(null);
		tail = new LLNode<E>(null);
		
		head.next = tail;
		tail.prev = head;
	}

	/**
	 * Appends an element to the end of the list
	 * @param element The element to add
	 */
	public boolean add(E element ) 
	{
		// TODO: Implement this method
		
		if(element == null){
			throw new NullPointerException();
		}
		
		
		LLNode<E> n = new LLNode<E>(element);
		
		n.prev = tail.prev;
		n.next = tail.prev.next;
		
		tail.prev.next = n;
		tail.prev = n;
		
		size++;
		
		return true;
	}

	/** Get the element at position index 
	 * @throws IndexOutOfBoundsException if the index is out of bounds. */
	public E get(int index) 
	{
		// TODO: Implement this method.
		
		if(index < 0 || index > size-1)
			throw new IndexOutOfBoundsException();
		
		return goTo(index).data;
	}

	/**
	 * Add an element to the list at the specified index
	 * @param The index where the element should be added
	 * @param element The element to add
	 */
	public void add(int index, E element ) 
	{
		// TODO: Implement this method
		
		// Checking if element is null
		if(element == null){
			throw new NullPointerException();
		}
		// Checking the index is reasonable
		else if(index > size || index < 0){
			throw new IndexOutOfBoundsException();
		}
		
		// Checking if the list is empty if so just add
		if(goTo(index) == null){
			add(element);
			return;
		}
		
		// Retrieving the element which is located in the given index
		LLNode<E> current = goTo(index);
		//System.out.println("-" + current.data + "-");
		
		// Making new node object for the new element
		LLNode<E> newElement = new LLNode<E>(element);
		
		newElement.prev = current.prev;
		newElement.next = current;
		
		current.prev = newElement;
		newElement.prev.next = newElement;
		
		size++;
	}


	/** Return the size of the list */
	public int size() 
	{
		// TODO: Implement this method
		return size;
	}

	/** Remove a node at the specified index and return its data element.
	 * @param index The index of the element to remove
	 * @return The data element removed
	 * @throws IndexOutOfBoundsException If index is outside the bounds of the list
	 * 
	 */
	public E remove(int index) 
	{
		// TODO: Implement this method
		
		if(index < 0 || index >= size){
			throw new IndexOutOfBoundsException();
		}
		
		LLNode<E> node = goTo(index);
		
		if(node == null){
			throw new NullPointerException();
		}
		
		E data = node.data;
		
		node.prev.next = node.next;
		node.next.prev = node.prev;
		
		size--;
		
		return data;
	}

	/**
	 * Set an index position in the list to a new element
	 * @param index The index of the element to change
	 * @param element The new element
	 * @return The element that was replaced
	 * @throws IndexOutOfBoundsException if the index is out of bounds.
	 */
	public E set(int index, E element) 
	{
		// TODO: Implement this method
		
		if(index < 0 || index >= size){
			throw new IndexOutOfBoundsException();
		}
		
		if(element == null){
			throw new NullPointerException();
		}
		
		
		LLNode<E> node = goTo(index);
		E oldData = node.data;
		
		node.data = element;
		
		return oldData;
	}  
	
	/* Goes and returns LLNode in a particular index */
	public LLNode<E> goTo(int index){
		
		LLNode<E> node = null;
		
		if(!head.next.equals(tail)){
			node = head.next;
		}
		
		for(int i=0; i<index; i++){
			
			if(node.next != null){
				//System.out.println("asa");
				node = node.next;
			}
		}
		
		return node;
	}
}

class LLNode<E> 
{
	LLNode<E> prev;
	LLNode<E> next;
	E data;

	// TODO: Add any other methods you think are useful here
	// E.g. you might want to add another constructor

	public LLNode(E e) 
	{
		this.data = e;
		this.prev = null;
		this.next = null;
	}
	
	public LLNode(E e, LLNode<E> prev, LLNode<E> next){
		this.data = e;
		this.prev = prev;
		this.next = next;
	}
	
	@Override
	public String toString(){
		return "" + data;
	}

}
