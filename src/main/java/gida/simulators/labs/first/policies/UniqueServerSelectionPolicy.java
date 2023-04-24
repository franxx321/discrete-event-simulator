package gida.simulators.labs.first.policies;

import java.util.List;
import gida.simulators.labs.first.resources.Server;

public class UniqueServerSelectionPolicy implements ServerSelectionPolicy {

    @Override
    public Server selectServer(List<Server> servers) {
        return servers.get(0);
    }

}
