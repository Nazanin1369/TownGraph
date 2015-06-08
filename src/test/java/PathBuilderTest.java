import junit.framework.TestCase;

public class PathBuilderTest extends TestCase {

	public void testFindAllPaths() {
		Graph g1 = new Graph("AB3, BC3, CD3, DA3");

		PathBuilder pf1_1 = new PathBuilder(new Condition("<", 101, "stops"), null, false);
		assertTrue(pf1_1.buildAllPaths(g1, g1.getNode("A"), g1.getNode("A")).length == 25);

		PathBuilder pf1_2 = new PathBuilder(new Condition("<", 12, "distance"), null, false);
		assertTrue(pf1_2.buildAllPaths(g1, g1.getNode("D"), g1.getNode("D")).length == 0);
		assertTrue(pf1_2.buildAllPaths(g1, g1.getNode("D"), g1.getNode("C")).length == 1);
		
		Graph g2 = new Graph("AB2, BA3, BD5, BE7, DB11, EB13, CE17, EC19, DE23, ED29, CF31 " +
		                     "FC37, EF41, FE43, FA53, AF59, DA61, AD67, EA71, AE73");

		PathBuilder pf2_1 = new PathBuilder(new Condition("<", 4, "stops"), null, true);
		assertTrue(pf2_1.buildAllPaths(g2, g2.getNode("A"), g2.getNode("A")).length == 12);

		PathBuilder pf2_2 = new PathBuilder(new Condition("<", 5, "stops"), null, true);
		assertTrue(pf2_2.buildAllPaths(g2, g2.getNode("A"), g2.getNode("A")).length == 34);
		
		// The acid test. If this one fails, might have to increase the Java Heap space
		PathBuilder pf2_3 = new PathBuilder(new Condition("<", 10, "stops"), null, false);
		assertTrue(pf2_3.buildAllPaths(g2, g2.getNode("A"), g2.getNode("A")).length == 26776);

		PathBuilder pf2_4 = new PathBuilder(new Condition("<", 6, "stops"),
										  new Condition("=", 88, "distance"), 
										  false);
		assertTrue(pf2_4.buildAllPaths(g2, g2.getNode("A"), g2.getNode("A")).length == 1);
	}

}
