package ule.edi.limitedpriorityqueue;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.*;




public class LimitedPriorityQueueLinkedTests {

	
	private LimitedPriorityQueueLinkedImpl<String> pq3;
	private LimitedPriorityQueueLinkedImpl<String> pq5;
	private LimitedPriorityQueueLinkedImpl<String> pq1;
	
	
	public LimitedPriorityQueueLinkedTests() {
		
		

	}
	
	@Before
	public void testBefore() throws Exception{
		
	    pq3 = new LimitedPriorityQueueLinkedImpl<String>(3); // limitado a 3 elementos
	    pq5 = new LimitedPriorityQueueLinkedImpl<String>(5); // limitado a 5 elementos
	    pq1 = new LimitedPriorityQueueLinkedImpl<String>(1); // limitado a 1 elemento

	}
	
	@Test
	public void testSomething() throws Exception {
		
	    Assert.assertEquals(pq3.isEmpty(), true);
	    Assert.assertEquals(pq3.isFull(), false);
	    Assert.assertEquals(pq3.getSize(), 0);
	    Assert.assertEquals(pq3.toString(), "[]");
	}
	
	@Test
	public void testGetCapacity() throws Exception{
		
		assertEquals(3, pq3.getCapacity());
		assertEquals(5, pq5.getCapacity());
	}
	
	@Test
	public void testGetSize() throws Exception{
		
		assertEquals(0, pq3.getSize());
	}
	
	@Test
	public void testIsFullTrue() throws Exception{
		
		String e0 = "Huenkai";
		String e1 = "Sehun";
		String e2 = "Chanyeol";
		
		pq3.enqueue(1, e0);
		pq3.enqueue(1, e1);
		pq3.enqueue(1, e2);
		
		assertTrue(pq3.isFull());
		
		
	}
	
	@Test
	public void testIsFullFalse() throws Exception{
		
		String e0 = "Huenkai";
		String e1 = "Sehun";
		
		pq3.enqueue(1, e0);
		pq3.enqueue(1, e1);
		
		assertFalse(pq3.isFull());
		
	}
	
	
	@Test
	public void testEmptyTrue() throws Exception {
		
	    Assert.assertEquals(pq3.isEmpty(), true);
	    Assert.assertEquals(pq3.getSize(), 0);
	    Assert.assertEquals(pq3.toString(), "[]");
	}
	
	@Test
	public void testEmptyFalse() throws Exception {
		
		String e0 = "Huenkai";
		String e1 = "Sehun";
		
		pq3.enqueue(1, e0);
		pq3.enqueue(1, e1);
		
	    assertEquals(false, pq3.isEmpty());
	}

	@Test (expected = NullPointerException.class)
	public void testEnqueueNull() throws EmptyCollectionException {
		
		pq3.enqueue(1, null);
		pq5.enqueue(2, null);
		
	}
	
	
	@Test (expected = IllegalArgumentException.class)
	public void testEnqueueInvalidPriority() throws EmptyCollectionException{
		
		pq3.enqueue(0, null);
		pq3.enqueue(800, null);
		
	}
	
	
	@Test
	public void testEnqueueFirstIfFull() throws EmptyCollectionException {
		
		String e0 = "Huenkai";
		String e1 = "Sehun";
		String e2 = "Sana";
		String e3 = "Mina";
		
		assertTrue(pq3.isEmpty());
		pq3.enqueue(2, e0);
		pq3.enqueue(2, e1);
		pq3.enqueue(2, e2);
		
		assertTrue(pq3.isFull());
		assertEquals( e2,pq3.enqueue(1, e3));
			
	}
	
	@Test
	public void testEnqueueFirstIfFullSize1() throws EmptyCollectionException {
		
		String e0 = "Huenkai";
		
		assertTrue(pq1.isEmpty());
		pq1.enqueue(2, e0);
		
		assertTrue(pq1.isFull());
		assertEquals(e0, pq1.enqueue(1, e0));
		
	}
	
	
	@Test
	public void testInsertarHastaLLenar() throws Exception{
	    Assert.assertEquals(pq3.enqueue(1, "Prior1_1"), null);
	    Assert.assertEquals(pq3.isEmpty(), false);
	    Assert.assertEquals(pq3.getSize(), 1);
	    Assert.assertEquals(pq3.enqueue(2, "Prior2_1"), null);
	    Assert.assertEquals(pq3.isEmpty(), false);
	    Assert.assertEquals(pq3.getSize(), 2);	
	    Assert.assertEquals(pq3.enqueue(2, "Prior2_2"), null);
	    Assert.assertEquals(pq3.isEmpty(), false);
	    Assert.assertEquals(pq3.getSize(), 3);	
	    Assert.assertEquals(pq3.isFull(), true);
	    Assert.assertEquals(pq3.toString(), "[( Priority:1 (Prior1_1)), ( Priority:2 (Prior2_1, Prior2_2))]");
	  
	}
	
	@Test
	public void testInsertarMenorPrioEnLLena() throws Exception{
	    Assert.assertEquals(pq3.enqueue(1, "Prior1_1"), null);
	    Assert.assertEquals(pq3.isEmpty(), false);
	    Assert.assertEquals(pq3.getSize(), 1);
	    Assert.assertEquals(pq3.enqueue(2, "Prior2_1"), null);
	    Assert.assertEquals(pq3.isEmpty(), false);
	    Assert.assertEquals(pq3.getSize(), 2);	
	    Assert.assertEquals(pq3.enqueue(2, "Prior2_2"), null);
	    Assert.assertEquals(pq3.isEmpty(), false);
	    Assert.assertEquals(pq3.getSize(), 3);	
	    Assert.assertEquals(pq3.isFull(), true);
	    Assert.assertEquals(pq3.toString(), "[( Priority:1 (Prior1_1)), ( Priority:2 (Prior2_1, Prior2_2))]");
	    Assert.assertEquals(pq3.enqueue(2, "Prior2_3"), "Prior2_3");
	    Assert.assertEquals(pq3.toString(), "[( Priority:1 (Prior1_1)), ( Priority:2 (Prior2_1, Prior2_2))]");
	  
	}
	
	@Test
	public void testInsertarMayorPrioEnLLena() throws Exception{
	    Assert.assertEquals(pq3.enqueue(1, "Prior1_1"), null);
	    Assert.assertEquals(pq3.enqueue(2, "Prior2_1"), null);
	    Assert.assertEquals(pq3.enqueue(2, "Prior2_2"), null);
	    Assert.assertEquals(pq3.toString(), "[( Priority:1 (Prior1_1)), ( Priority:2 (Prior2_1, Prior2_2))]");
	    Assert.assertEquals(pq3.enqueue(1, "Prior1_2"), "Prior2_2");
	    Assert.assertEquals(pq3.toString(), "[( Priority:1 (Prior1_1, Prior1_2)), ( Priority:2 (Prior2_1))]");
	  
	}
	
	@Test
	public void testDequeueLast() throws EmptyCollectionException{
		
		String e0 = "Mark";
		assertEquals(true, pq3.isEmpty());
		
		pq3.enqueue(1, e0);
		assertEquals(1, pq3.getSize());
		
		
		
	}
	@Test 
	public void testFirstOk() throws EmptyCollectionException{
		
		String e0 = "Mark";
		assertEquals(true, pq3.isEmpty());
		pq3.enqueue(1, e0);
		
		assertEquals(e0, pq3.first());
		
	}
	
	@Test (expected = EmptyCollectionException.class)
	public void testFirstEmpty() throws EmptyCollectionException{
		
		String e0 = "Mark";
		assertEquals(true, pq3.isEmpty());
		
		pq3.first();
		
	}
	
	@Test 
	public void testDequeueOk() throws EmptyCollectionException{
		
		String e0 = "Mark";
		String e1 = "Taeyong";
		assertEquals(true, pq3.isEmpty());
		assertEquals(true, pq5.isEmpty());
		
		pq3.enqueue(1,e0);
		pq3.enqueue(2,e1);
		assertEquals(e0, pq3.dequeue());
		
		pq5.enqueue(1, e0);
		assertEquals(e0, pq5.dequeue());
	
	}
	
	@Test (expected = EmptyCollectionException.class)
	public void testDequeueEmpty() throws EmptyCollectionException{
		
		String e0 = "Mark";
		String e1 = "Taeyong";
		assertEquals(true, pq3.isEmpty());
		assertEquals(true, pq5.isEmpty());
		
		pq3.dequeue();
		pq5.dequeue();
		
	}
	
	
}


