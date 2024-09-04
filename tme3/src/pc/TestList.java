package pc;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import pc.iter.SimpleList;
import pc.rec.SimpleListRec;

public class TestList {

	@Test
	public void testSimpleList() {
		IList<String> list = new SimpleList<>();

		runConcurrentTest(list, 10, 1000);
	}

	@Test
	public void testSimpleListRec() {
		IList<String> list = new SimpleListRec<>();

		runConcurrentTest(list, 10, 1000);
	}

	public static void testList(IList<String> list) {
		// Tests des versions itératives
		list.add("Hello");
		list.add("World");
		System.out.println("Taille : " + list.size());
		assertEquals(2, list.size());
		System.out.println("Contient 'World' : " + list.contains("World"));
		assertEquals(true, list.contains("World"));
		assertEquals(false, list.contains("Master"));
		
		list.clear();
		assertEquals(0, list.size());
		System.out.println("Taille après clear : " + list.size());
	}

	private void runConcurrentTest(IList<String> list, int N, int M) {
		System.out.println("Running test of "+list.getClass().getSimpleName());
		testList(list);

		long startTime = System.currentTimeMillis();

		List<Thread> threads = new ArrayList<>();

		// Create threads to add elements to the list

		// Create threads to check contains for non-existent elements

		// Start all threads

		// Wait for all threads to finish

		// Check that the list size is N * M
		// assertEquals("List size should be N * M", N * M, list.size());

		long endTime = System.currentTimeMillis();
		System.out.println("Test completed in " + (endTime - startTime) + " milliseconds");
	}

	// TODO support pour les threads
	static class AddTask implements Runnable {

		@Override
		public void run() {
		}
	}

}

