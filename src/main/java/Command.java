/**
 * Created by nazanin on 6/8/15.
 */
public class Command {
    private String [] parameters;

    public void setParameters(String[] parameters)  {
        this.parameters = parameters;
    }

    public String[] getParameters() {
        return parameters;
    }

    public String toString() {
        StringBuilder str = new StringBuilder();
        for (String s : parameters) {
            str.append(s + " ");
        }
        return str.toString();
    }

    public String execute(Graph g) {
        return Application.getProperty("not_implemented");
    }

    protected Node[] getNodes(Graph graph, String s) {
        Node[] nodes = new Node[s.length()];
        int i = 0;
        for (char c: s.toCharArray()) {
            String name = String.valueOf(c);
            nodes[i++] = graph.getNode(name);
        }
        return nodes;
    }
}
