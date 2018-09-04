/**
 * 
 */
package textgen;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Before;
import org.junit.Test;

/**
 * @author UC San Diego MOOC team
 *
 */
public class MyLinkedListTester {

	private static final int LONG_LIST_LENGTH =10; 

	MyLinkedList<String> shortList;
	MyLinkedList<Integer> emptyList;
	MyLinkedList<Integer> longerList;
	MyLinkedList<Integer> list1;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		// Feel free to use these lists, or add your own
	    shortList = new MyLinkedList<String>();
		shortList.add("A");
		shortList.add("B");
		emptyList = new MyLinkedList<Integer>();
		longerList = new MyLinkedList<Integer>();
		for (int i = 0; i < LONG_LIST_LENGTH; i++)
		{
			longerList.add(i);
		}
		list1 = new MyLinkedList<Integer>();
		list1.add(65);
		list1.add(21);
		list1.add(42);
		
	}

	
	/** Test if the get method is working correctly.
	 */
	/*You should not need to add much to this method.
	 * We provide it as an example of a thorough test. */
	@Test
	public void testGet()
	{
		//test empty list, get should throw an exception
		try {
			emptyList.get(0);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
			
		}
		
		// test short list, first contents, then out of bounds
		assertEquals("Check first", "A", shortList.get(0));
		assertEquals("Check second", "B", shortList.get(1));
		
		try {
			shortList.get(-1);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		try {
			shortList.get(2);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		// test longer list contents
		for(int i = 0; i<LONG_LIST_LENGTH; i++ ) {
			assertEquals("Check "+i+ " element", (Integer)i, longerList.get(i));
		}
		
		// test off the end of the longer array
		try {
			longerList.get(-1);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		try {
			longerList.get(LONG_LIST_LENGTH);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		}
		
	}
	
	
	/** Test removing an element from the list.
	 * We've included thel example from the concept challenge.
	 * You will want to add more tests.  */
	@Test
	public void testRemove()
	{
		int a = list1.remove(0);
		assertEquals("Remove: check a is correct ", 65, a);
		assertEquals("Remove: check element 0 is correct ", (Integer)21, list1.get(0));
		assertEquals("Remove: check size is correct ", 2, list1.size());
		
		// TODO: Add more tests here
	}
	
	/** Test adding an element into the end of the list, specifically
	 *  public boolean add(E element)
	 * */
	@Test
	public void testAddEnd()
	{
        // TODO: implement this test
		
		// Checking if it's possible to add null
		try {
			list1.add(null);
			fail("Null Pointer Exception");
		}
		catch (NullPointerException e) {
		}
		
		
	}

	
	/** Test the size of the list */
	@Test
	public void testSize()
	{
		assertEquals(emptyList.size(), 0);
		
		emptyList.add(1);
		emptyList.add(2);
		emptyList.add(1, 5);
		emptyList.remove(0);
		
		assertEquals(emptyList.size(), 2);
		
		assertEquals(longerList.size(), LONG_LIST_LENGTH);
		
		shortList.remove(1);
		
		assertEquals(shortList.size(), 1);
	}

	
	
	/** Test adding an element into the list at a specified index,
	 * specifically:
	 * public void add(int index, E element)
	 * */
	@Test
	public void testAddAtIndex()
	{
        // TODO: implement this test
		
		// Feel free to use these lists, or add your own
	    shortList = new MyLinkedList<String>();
		shortList.add("A");
		shortList.add("B");
		emptyList = new MyLinkedList<Integer>();
		longerList = new MyLinkedList<Integer>();
		
		
		try {
			list1.add(0, null);
			shortList.add(1, null);
			fail("Null Pointer Exception");
		}
		catch (NullPointerException e) {
		}
		
		try{
			
			emptyList.add(1, 0);
			list1.add(-1, 1);
			shortList.add(5, "A");
			
		}catch(IndexOutOfBoundsException e){
			
		}
		
		
		for (int i = 0; i < LONG_LIST_LENGTH/2; i++){
			longerList.add(i, i);
		}
		
		for(int i = 0; i<LONG_LIST_LENGTH/2; i++ ) {
			assertEquals("Check "+i+ " element", (Integer)i, longerList.get(i));
		}
			
	
		
		
	}
	
	/** Test setting an element in the list */
	@Test
	public void testSet()
	{
	    // TODO: implement this test
		
		try{
			shortList.set(0, null);
			fail("Null Pointer Exception fail");
		}
		catch(NullPointerException e){
			
		}
		
		try{
			list1.set(-1, 0);
			fail("IndexOutOfBoundsExeption fail");
		}
		catch(IndexOutOfBoundsException e){
		
		}
		
		
		try{
			emptyList.set(0, 0);
			fail();
		}
		catch(Exception e){
			
		}
		
		
		assertEquals(shortList.set(1, "B"), "B");
		assertEquals(shortList.set(0, "C"), "A");
		assertEquals(shortList.get(0), "C");
	    
	}
	
	
	// TODO: Optionally add more test methods.
	
}
