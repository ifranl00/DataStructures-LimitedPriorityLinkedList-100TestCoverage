package ule.edi.limitedpriorityqueue;

import static org.junit.Assert.*;
import org.junit.*;

public class LinkedQueueTest {

	private LinkedQueue cola;
	
	@Before
	public void testBefour() throws Exception{
		
		cola = new LinkedQueue<String>();
	}
	
	@Test
	public void testSomething() throws Exception{
		
		assertEquals(cola.isEmpty(), true);
		assertEquals(cola.toString(), "");
	}

	@Test
	public void testEnqueueOk() throws Exception {
		
		String s0 = "element0";
		String s1 = "element1";
		
		cola.enqueue(s0);
	
		assertEquals(1, cola.size());
		
		cola.enqueue(s1);
		
		assertEquals(2, cola.size());
	}
	
	@Test (expected =  NullPointerException.class)
	public void testEnqueueNull() throws Exception{
		
		cola.enqueue(null);
	}
	
	@Test
	public void testDequeueOk() throws EmptyCollectionException {
		
		String s0 = "element0";
		String s1 = "element1";
		
		cola.enqueue(s0);
		cola.dequeue();
		
		cola.enqueue(s0);
		cola.enqueue(s1);
		cola.dequeue();
	}

	@Test (expected = EmptyCollectionException.class)
	public void testDequeueEmpty() throws EmptyCollectionException {
		
		cola.dequeue();
	}

	@Test 
	public void testFirstOk() throws EmptyCollectionException {
		
		String s0 = "element0";
		String s1 = "element1";
		
		cola.enqueue(s0);
		cola.enqueue(s1);
		
		assertEquals(s0, cola.first());
	}
	
	@Test (expected = EmptyCollectionException.class) 
	public void testFirstEmpty() throws EmptyCollectionException {
		
		cola.first();
	}

	@Test
	public void testIsEmptyTrue() throws Exception {
		
		assertTrue(cola.isEmpty());
		
	}
	
	@Test
	public void testIsEmptyFalse() throws Exception{
		
		String s0 = "element0";
		
		cola.enqueue(s0);
		
		assertFalse(cola.isEmpty());
		
	}

	@Test
	public void testSize() throws Exception{
		
		assertEquals(0, cola.size());
		
	}

	@Test
	public void testDequeueLastOk() throws EmptyCollectionException {
		
		String s0 = "element0";
		String s1 = "element1";
		String s2 = "element2";
		String s3 = "element3";
		
		cola.enqueue(s0);
		assertEquals(s0, cola.dequeueLast());
		
		cola.enqueue(s1);
		cola.enqueue(s2);
		cola.enqueue(s3);
		assertEquals(s3, cola.dequeueLast());

	}
	
	@Test (expected = EmptyCollectionException.class)
	public void testDequeueLastEmpty() throws EmptyCollectionException {
		
		cola.dequeueLast();
	}

	@Test
	public void testToString() throws Exception {
		
		String s0 = "element0";
		String s1 = "element1";
		String s2 = "element2";
		String s3 = "element3";
		
		cola.enqueue(s0);
		cola.enqueue(s1);
		cola.enqueue(s2);
		cola.enqueue(s3);
		
		assertEquals("element0, element1, element2, element3",cola.toString());
	}

}
