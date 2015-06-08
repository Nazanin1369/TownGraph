/**
 * Created by nazanin on 6/8/15.
 */

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class Application {
    private ResourceBundle properties;
    private static Application instance;

    private Application() {
        try {
            properties = ResourceBundle.getBundle("graph");
        } catch(MissingResourceException e) {
            System.err.println("No such a file: graph.properties");
            System.exit(1);
        }
    }

    public static Application getInstance() {
        if (instance == null) {
            instance = new Application();
        }
        return instance;
    }

    public static String getProperty(String name) {
        String s;
        try {
            s = getInstance().properties.getString(name);
        } catch (MissingResourceException e) {
            System.err.println("WARNING: missing data: " + name);
            return "";
        }
        return s;
    }

    private static FileInputStream getFileInputStream(String name) {
        FileInputStream stream = null;
        try {
            stream = new FileInputStream(name);
        } catch (FileNotFoundException e) {
            System.err.println(name + ": File not found");
            System.exit(1);
        }
        return stream;
    }

    public static void main( String[] args )
    {
        if (args.length != 2) {
            System.err.println(getProperty("usage"));
            System.exit(1);
        }

        String graphFilename    = args[0];
        String commandsFilename = args[1];

        try {
            Graph graph = new Graph(getFileInputStream(graphFilename));
            Commands actions = new Commands(getFileInputStream(commandsFilename));

            System.out.println(actions.execute(graph));
        } catch (IOException e) {
            System.err.println("FATAL: " + e.getMessage());
            System.exit(1);
        }
    }
}
