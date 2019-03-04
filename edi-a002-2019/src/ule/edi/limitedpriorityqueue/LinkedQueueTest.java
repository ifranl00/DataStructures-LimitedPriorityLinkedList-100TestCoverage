package ule.edi.limitedpriorityqueue;

import static org.junit.Assert.*;
import org.junit.*;

public class LinkedQueueTest {

	private LinkedQueue cola;
	
	@Before
	public void testBefour() throws Exception{
		
		cola = new LinkedQueue();
	}
	
	@Test
	public void testSomething() {
		
		assertEquals(cola.isEmpty(), true);
		assertEquals(cola.toString(), "");
		
	}

	@Test
	public void testEnqueue() {
		fail("Not yet implemented");
	}

	@Test
	public void testDequeue() {
		fail("Not yet implemented");
	}

	@Test
	public void testFirst() {
		fail("Not yet implemented");
	}

	@Test
	public void testIsEmptyTrue() {
		
		assertTrue(cola.isEmpty());
		
	}
	
	@Test
	public void testIsEmptyFalse() {
		
		
	}

	@Test
	public void testSize() {
		
		assertEquals(0, cola.size());
		
	}

	@Test
	public void testDequeueLast() {
		fail("Not yet implemented");
	}

	@Test
	public void testToString() {
		fail("Not yet implemented");
	}

}
