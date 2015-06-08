import junit.framework.TestCase;

public class ShortestPathCommandTest extends TestCase {

	public void testExecute() {
		Graph g1 = new Graph("AB2, BA3, BD5, BE7, DB11, EB13, CE17, EC19, DE23, ED29, CF31 " +
				  "FC37, EF41, FE43, FA53, AF59, DA61, AD67, EA71, AE73");
		
		ShortestPathCommand a1 = new ShortestPathCommand();
		a1.setParameters(new String[] {"-", "BF"});
		assertEquals(a1.execute(g1), "48");

		try {
			ShortestPathCommand a2 = new ShortestPathCommand();
			a2.setParameters(new String[] {"-", "BFA"});
			a2.execute(g1);
			fail("Invalid Node Specification accepted");
		} catch (IllegalArgumentException e) {
			
		}
		
		try {
			ShortestPathCommand a3 = new ShortestPathCommand();
			a3.setParameters(new String[] {"-"});
			a3.execute(g1);
			fail("Missing Node Specification accepted");
		} catch (IllegalArgumentException e){
			
		}
	}

}
