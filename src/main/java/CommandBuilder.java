/**
 * Created by nazanin on 6/8/15.
 */

import java.util.Map;
import java.util.TreeMap;

public class CommandBuilder {
    private Map<String, Class<?> > actionsMap;

    public CommandBuilder() {
        actionsMap = new TreeMap<String, Class<?> >();

        actionsMap.put("distance?", DistanceCommand.class);
        actionsMap.put("trips?", TripsCommand.class);
        actionsMap.put("shortest?", ShortestPathCommand.class);
    }

    public Command buildCommand(String s) {
        Class<?> c = actionsMap.get(s);
        Command action = null;

        if (c != null) {
            try {
                action = (Command) c.newInstance();
            } catch (Exception e) {
                System.err.println(Application.getProperty("internal_error") + " " + s + " command: " + e.getMessage());
            }
        }

        return action;
    }


}
