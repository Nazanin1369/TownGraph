import junit.framework.TestCase;

public class TripsCommandTest extends TestCase {

	public void testExecute() {
		Graph g1 = new Graph("AB3, BC3, CD3, DA3");
		TripsCommand a1 = new TripsCommand();
		a1.setParameters(new String[] {"-", "<101", "stops", "AA"});
		assertEquals(a1.execute(g1), "25");
		
		try {
			TripsCommand a2 = new TripsCommand();
			a2.setParameters(new String[] {"-", "<101", "stops"});
			a2.execute(g1);
			fail("invalid action accepted");
		} catch (IllegalArgumentException e) {
		}

		TripsCommand a3 = new TripsCommand();
		a3.setParameters(new String[] {"-", "=6", "distance", "BD"});
		assertEquals(a3.execute(g1),"1");
	}

}
