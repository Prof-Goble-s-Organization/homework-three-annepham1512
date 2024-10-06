import static org.junit.Assert.*;

import java.util.NoSuchElementException;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class No7Tests {

	private CS232Iterator<String> it;
	private CS232ArrayList<String> myList;
	
	@Before
    public void setUp() throws Exception {
        myList = new CS232ArrayList<String>();
        it = myList.getIterator();
    }
    
    private void buildList() {
    	String[] list = {"one", "two", "three", "four", "five"};
    	for (String s : list) {
    		myList.add(s);
    	}
    }
    
    @Test
    public void testInitialHasNext() {
		buildList();
		assertTrue("should have next", it.hasNext());
    }
    
    @Test
    public void testInitialHasPrevious() {
		buildList();
		assertFalse("should not have previous", it.hasPrevious());
    }
    
	@Test
	public void testNext() {
		buildList();
		assertEquals("Incorrect value from next", "one", it.next());
	}
	
	@Test
	public void testPrevious() {
		buildList();
		it.next();
		assertEquals("Incorrect value from previous", "one", it.previous());
	}
    
	@Test
	public void testNextPreviousSequence() {
		buildList();
		it.next(); // 1
		it.next(); // 2
		assertEquals("Incorect value", "two", it.previous()); // 1 but return 2
		assertEquals("Incorect value", "two", it.next()); // 2 
		
		it.next(); // 3
		it.previous(); // 2
		assertEquals("Incorrect value", "two", it.previous()); // 1 but return 2
		assertEquals("Incorrect value", "one", it.previous()); 
	}
	
	@Test
	public void testNextHasNext() {
		buildList();
		for (int i=0; i<myList.size(); i++) {
			assertTrue("should have next", it.hasNext());
			it.next();
		}
		assertFalse("should not have next", it.hasNext());
	}
	
	@Test 
	public void testPreviousHasPrevious() {
		buildList();
		it.next(); // one
		assertTrue("Should have a previous", it.hasPrevious()); 
		// assuming head can considered as a previous, we have head before "one", so this might be true. 
		// However, I think that logic is not sensible, I would
		// keep my code the same, which would not pass the test case
		
		while (it.hasNext()) {
			it.next(); // The last element of the doubly linkedList
		}
		
		for (int i=0; i<myList.size(); i++) {
			assertTrue("should have previous", it.hasPrevious());
			it.previous();
		}
		
		assertFalse("Should not a previous", it.hasPrevious()); // This is conflicting with the assertTrue above
		// According to the assertTrue above, the first element has previous and I adjusted
		// my code based on that. But for this assertFalse, the test is saying the first 
		// element has no previous
	}
	
	@Test
	public void testNextException() {
		buildList();
		for (int i=0; i<myList.size(); i++) {
			it.next();
		}

		try {
			it.next();
			fail("Should throw NoSuchElementException.");
		}
		catch(NoSuchElementException e) {
			// pass.
		}
		catch(Exception e) {
			fail("Threw incorrect exception type, should be NoSuchElementException.");
		}
	}
	
	@Test 
	public void testPreviousExceptionInitally() {
		buildList();
		
		try {
			it.previous();
			fail("Should throw NoSuchElementException.");
		}
		catch(NoSuchElementException e) {
			// pass.
		}
		catch(Exception e) {
			fail("Threw incorrect exception type, should be NoSuchElementException.");
		}
	}
	
	@Test 
	public void testPreviousExceptionAfterMoves() {
		buildList();
		it.next();
		it.previous();
		
		try {
			it.previous();
			fail("Should throw NoSuchElementException.");
		}
		catch(NoSuchElementException e) {
			// pass.
		}
		catch(Exception e) {
			fail("Threw incorrect exception type, should be NoSuchElementException.");
		}
	}
}
