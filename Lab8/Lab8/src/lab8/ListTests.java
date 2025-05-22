package lab8;

import static org.junit.Assert.*;

import org.junit.Test;

public class ListTests {
	AryList<Integer> test = new AryList<Integer>();
	AryList<Integer> comp = new AryList<Integer>();
	
	@Test
	public void testAddContains() {
		test.add(0);
		assertTrue(test.contains(0));
	}
	
	@Test
	public void testAddContains2() {
		test.add(1);
		assertTrue(!test.contains(0));
	}
	
	@Test
	public void testAddContains3() {
		test.add(1);
		test.add(2);
		test.add(3);
		test.add(1,5);
		assertTrue(test.contains(2));
		assertTrue(test.contains(5));
	}
	
	@Test
	public void testReplace() {
		test.add(1);
		test.add(2);
		test.add(3);
		test.replace(1,5);
		assertTrue(!test.contains(2));
		assertTrue(test.contains(5));
	}
	
	@Test
	public void testRemove() {
		test.add(1);
		test.add(2);
		test.add(3);
		test.add(4);
		test.add(5);
		test.remove(2);
		test.remove(1);
		assertTrue(!test.contains(2));
		assertTrue(test.contains(1));
		assertTrue(!test.contains(3));
	}
	
	@Test
	public void testIsEmptyClear() {
		assertTrue(test.isEmpty());
		test.add(1);
		assertTrue(!test.isEmpty());
		test.add(1);
		test.add(4);
		test.add(32);
		test.add(23);
		test.add(3);
		assertTrue(!test.isEmpty());
		test.clear();
		assertTrue(test.isEmpty());
	}
	
	
	
	
	

	
	@Test
	public void testScaleByN() {
		test.add(0);
		test.add(1);
		test.add(2);
		test.add(3);
		test.add(4);
		test.add(5);
		
		comp.add(1);
		
		comp.add(2);
		comp.add(2);
		
		comp.add(3);
		comp.add(3);
		comp.add(3);
		
		comp.add(4);
		comp.add(4);
		comp.add(4);
		comp.add(4);
		
		comp.add(5);
		comp.add(5);
		comp.add(5);
		comp.add(5);
		comp.add(5);
		test.scaleByN();
		assertEquals(comp.toArray(),test.toArray()); 
	}
	
	@Test
	public void testRemoveDup() {
		test.add(0);
		test.add(1);
		test.add(2);
		test.add(3);
		test.add(4);
		test.add(5);
		
		comp.add(0);
		
		comp.add(1);
		
		comp.add(2);
		comp.add(2);
		
		comp.add(3);
		comp.add(3);
		comp.add(3);
		
		comp.add(4);
		comp.add(4);
		comp.add(4);
		comp.add(4);
		
		comp.add(5);
		comp.add(5);
		comp.add(5);
		comp.add(5);
		comp.add(5);
		comp.removeDuplicates();
		assertEquals(comp.toArray(),test.toArray());
		
	}

}
