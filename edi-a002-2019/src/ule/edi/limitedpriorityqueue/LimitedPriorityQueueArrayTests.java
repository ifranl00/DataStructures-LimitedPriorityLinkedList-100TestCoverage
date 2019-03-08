package ule.edi.limitedpriorityqueue;

import org.junit.*;

import static org.junit.Assert.*;

public class LimitedPriorityQueueArrayTests {

	
	private LimitedPriorityQueueArrayImpl<String> pq3;
	private LimitedPriorityQueueArrayImpl<String> pq5;
	
	
	public LimitedPriorityQueueArrayTests() throws Exception{
		
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testLimitedPriorityQueueArrayInvalidCapacity() throws IllegalArgumentException {
		
		pq3 = new LimitedPriorityQueueArrayImpl<String>(0,2);
		
	}
	
	@Before
	public void testBefore() throws Exception{
	    pq3 = new LimitedPriorityQueueArrayImpl<String>(3,2); // limitado a 3 elementos, las posibles prioridades son [1,2]
	    pq5 = new LimitedPriorityQueueArrayImpl<String>(5,3); // limitado a 5 elementos, las posibles prioridades son [1,2,3]

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

	
	
	
	@Test
	public void testInsertarHastaLLenar() throws Exception{
	    Assert.assertEquals(null, pq3.enqueue(1, "Prior1_1"));
	    Assert.assertEquals(false, pq3.isEmpty());
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
	    Assert.assertEquals(pq3.enqueue(2, "Prior2_1"), null);
	    Assert.assertEquals(pq3.enqueue(2, "Prior2_2"), null);
	    Assert.assertEquals(pq3.toString(), "[( Priority:1 (Prior1_1)), ( Priority:2 (Prior2_1, Prior2_2))]");
	    Assert.assertEquals(pq3.enqueue(2, "Prior2_3"), "Prior2_3");    // El elemento insertado tiene menor prioridad que los que estaban, por tanto es el que sale
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
		pq5.enqueue(1, e0);
		
		assertEquals(e0, pq3.dequeue());
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