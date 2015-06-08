/**
 * Created by nazanin on 6/8/15.
 */
public class Edge {
    private Node destination;
    private int  distance;

    public Edge() {
        destination = null;
        distance = 0;
    }

    public Edge(Node n, int d) {
        destination = n;
        distance = d;
    }

    public String toString() {
        return destination.getName() + ": " + distance;
    }

    public Node getDestination() {
        return destination;
    }

    public int getDistance() {
        return distance;
    }
}
