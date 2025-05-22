package lab6;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestExtended {
	ExtendedQueue<Integer> q = new ExtendedQueue<Integer>();
	ExtendedStack<Integer> s = new ExtendedStack<Integer>();

	@Test
	public void testStackSizeEmpty() {
		assertEquals(0,s.getCurrentSize());
	}
	@Test
	public void testStackSizeOne() {
		s.push(1);
		assertEquals(1,s.getCurrentSize());
	}
	@Test
	public void testStackSizeMultiple() {
		s.push(1);s.push(2);s.push(3);s.push(4);s.push(5);s.push(6);
		assertEquals(6,s.getCurrentSize());
		assertEquals(6,(int)s.pop());
		assertEquals(5,(int)s.pop());
		assertEquals(4,(int)s.pop());
		assertEquals(3,(int)s.pop());
		assertEquals(2,(int)s.pop());
		assertEquals(1,(int)s.pop());
	}
	@Test
	public void testStackLast() {
		s.push(1);s.push(2);s.push(3);s.push(4);s.push(5);s.push(6);
		int t = s.last();
		assertEquals(1,t);
		assertEquals(6,s.getCurrentSize());
		assertEquals(6,(int)s.pop());
		assertEquals(5,(int)s.pop());
		assertEquals(4,(int)s.pop());
		assertEquals(3,(int)s.pop());
		assertEquals(2,(int)s.pop());
		assertEquals(1,(int)s.pop());
	}
	@Test
	public void testStackLast2() {
		s.push(1);
		int t = s.last();
		assertEquals(1,t);
		assertEquals(1,(int)s.pop());
	}
	@Test
	public void testStackLast3() {
		s.push(2);s.push(3);s.push(4);s.push(5);s.push(6);
		int t = s.last();
		assertEquals(2,t);
		assertEquals(6,(int)s.pop());
		assertEquals(5,(int)s.pop());
		assertEquals(4,(int)s.pop());
		assertEquals(3,(int)s.pop());
		assertEquals(2,(int)s.pop());
	}
	@Test
	public void testStackLast4() {
		Object t = s.last();
		assertEquals(null,t);
	}
	@Test
	public void testStackRevese() {
		s.push(1);s.push(2);s.push(3);s.push(4);s.push(5);s.push(6);
		s.reverse();
		assertEquals(1,(int)s.pop());
		assertEquals(2,(int)s.pop());
		assertEquals(3,(int)s.pop());
		assertEquals(4,(int)s.pop());
		assertEquals(5,(int)s.pop());
		assertEquals(6,(int)s.pop());
	}
	@Test
	public void testStackRevese2() {
		s.push(1);
		s.reverse();
		assertEquals(1,(int)s.pop());
	}
	@Test
	public void testStackRevese3() {
		s.reverse();
	}
	@Test
	public void testStackDeleteAllNothing() {
		s.push(1);s.push(2);s.push(3);s.push(4);s.push(5);s.push(6);
		assertEquals(0,s.deleteAll(0));
		assertEquals(6,s.getCurrentSize());
		assertEquals(6,(int)s.pop());
		assertEquals(5,(int)s.pop());
		assertEquals(4,(int)s.pop());
		assertEquals(3,(int)s.pop());
		assertEquals(2,(int)s.pop());
		assertEquals(1,(int)s.pop());
	}
	@Test
	public void testStackDeleteAll() {
		s.push(1);s.push(2);s.push(1);s.push(4);s.push(1);s.push(6);
		assertEquals(3,s.deleteAll(1));
		assertEquals(3,s.getCurrentSize());
		assertEquals(6,(int)s.pop());
		assertEquals(4,(int)s.pop());
		assertEquals(2,(int)s.pop());
	}
	/*******************************************************************/
	
	
	@Test
	public void testQueueSizeEmpty() {
		assertEquals(0,q.getCurrentSize());
	}
	@Test
	public void testQueueSizeOne() {
		q.add(1);
		assertEquals(1,q.getCurrentSize());
	}
	@Test
	public void testQueueSizeMultiple() {
		q.add(1);q.add(2);q.add(3);q.add(4);q.add(5);q.add(6);
		assertEquals(6,q.getCurrentSize());
	}
	@Test
	public void testQueueLast() {
		q.add(1);q.add(2);q.add(3);q.add(4);q.add(5);q.add(6);
		int t = q.last();
		assertEquals(6,t);
	}
	@Test
	public void testQueueLast2() {
		q.add(1);
		int t = q.last();
		assertEquals(1,t);
	}
	@Test
	public void testQueueLast3() {
		q.add(2);q.add(3);q.add(4);q.add(5);
		int t = q.last();
		assertEquals(5,t);
	}
	@Test
	public void testQueueLast4() {
		Object t = q.last();
		assertEquals(null,t);
	}
	@Test
	public void testQueueRevese() {
		q.add(1);q.add(2);q.add(3);q.add(4);q.add(5);q.add(6);
		q.reverse();
		assertEquals(6,(int)q.poll());
		assertEquals(5,(int)q.poll());
		assertEquals(4,(int)q.poll());
		assertEquals(3,(int)q.poll());
		assertEquals(2,(int)q.poll());
		assertEquals(1,(int)q.poll());
	}
	@Test
	public void testQueueRevese2() {
		q.add(1);
		q.reverse();
		assertEquals(1,(int)q.poll());
	}
	@Test
	public void testQueueRevese3() {
		q.reverse();
	}
	@Test
	public void testQueueDeleteAllNothing() {
		q.add(1);q.add(2);q.add(3);q.add(4);q.add(5);q.add(6);
		assertEquals(0,q.deleteAll(0));
		assertEquals(6,q.getCurrentSize());
		assertEquals(1,(int)q.poll());
		assertEquals(2,(int)q.poll());
		assertEquals(3,(int)q.poll());
		assertEquals(4,(int)q.poll());
		assertEquals(5,(int)q.poll());
		assertEquals(6,(int)q.poll());
	}
	@Test
	public void testQueueDeleteAll() {
		q.add(1);q.add(2);q.add(1);q.add(4);q.add(1);q.add(6);
		assertEquals(3,q.deleteAll(1));
		assertEquals(3,q.getCurrentSize());
		assertEquals(2,(int)q.poll());
		assertEquals(4,(int)q.poll());
		assertEquals(6,(int)q.poll());
	}
	

}
