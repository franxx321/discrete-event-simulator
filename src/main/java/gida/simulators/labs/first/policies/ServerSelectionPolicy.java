package gida.simulators.labs.first.policies;

import java.util.List;
import gida.simulators.labs.first.resources.Server;

@FunctionalInterface
public interface ServerSelectionPolicy {

    /**
     * computes the server selection policy
     * 
     * @param servers the list of servers
     * @return the selected servers for arrival
     */
    Server selectServer(List<Server> servers);
}
