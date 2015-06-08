import junit.framework.TestCase;

public class CommandBuilderTest extends TestCase {

	private CommandBuilder testBuilder;

	public void testCreateAction() {
		testBuilder = new CommandBuilder();
		Command foo = testBuilder.buildCommand("foo");
		assertTrue(foo == null);
		Command distance = testBuilder.buildCommand("distance?");
		assertTrue(distance.getClass().equals(DistanceCommand.class));
		Command trips = testBuilder.buildCommand("trips?");
		assertTrue(trips.getClass().equals(TripsCommand.class));
		Command shortest = testBuilder.buildCommand("shortest?");
		assertTrue(shortest.getClass().equals(ShortestPathCommand.class));
	}
}
