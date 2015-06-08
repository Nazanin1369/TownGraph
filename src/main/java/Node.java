/**
 * Created by nazanin on 6/8/15.
 */
import java.util.ArrayList;
import java.util.List;

public class Node {
    List<Edge> adjacents;
    String name;

    String getName() {
        return name;
    }

    public Node(String name) {
        this.name = name;
        adjacents = new ArrayList<Edge>();
    }

    public boolean isEqual(Node n) {
        return n.name == this.name;
    }

    public void addEdge(Edge edge) {
        adjacents.add(edge);
    }

    List<Edge> getAdjacents() {
        return adjacents;
    }
}
