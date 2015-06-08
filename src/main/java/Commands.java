/**
 * Created by nazanin on 6/8/15.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Commands {
    private List<Command> commandsList;
    private CommandBuilder commandBuilder;

    /**
     * Reads an command specification and instantiates the required Command object
     * and puts it on the commands list for execution later.
     * @param str
     * @throws IllegalArgumentException
     */
    public void read(String str) throws IllegalArgumentException {
        if (!str.isEmpty()) {
            String words[] = str.split("\\s");

            // The general syntax of commands is:
            // <command query> [param1] [param2]...
            String name = words[0];
            Command command = commandBuilder.buildCommand(name);

            if (command == null) {
                throw new IllegalArgumentException(Application.getProperty("unknown_command") + ": " + name);
            }

            command.setParameters(words);

            commandsList.add(command);
        }
    }

    /**
     * Constructs an Commands object reading the commands to be executed from an
     * input stream
     * @param stream
     * @throws IOException
     */
    public Commands(InputStream stream) throws IOException {
        this();

        // Read commands from input stream
        BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
        String str;
        while((str = reader.readLine()) != null) {
            read(str);
        }
    }

    public Commands() {
        commandBuilder = new CommandBuilder();
        commandsList   = new ArrayList<Command>();
    }

    /**
     * Executes this command on the given graph
     * @param graph
     * @return the result of the command
     */
    public String execute(Graph graph) {
        StringBuilder s = new StringBuilder();

        for (Command cmd : commandsList) {
            s.append(cmd + " => " + cmd.execute(graph) + "\n");
        }

        return s.toString();
    }
}
