package gida.simulators.labs.first.engine;

import java.util.List;

import gida.simulators.labs.first.policies.ServerSelectionPolicy;
import gida.simulators.labs.first.resources.Server;
import gida.simulators.labs.first.utils.Randomizer;

public class AirportSim extends Engine {

    private FutureEventList fel;
    private List<Server> servers;

    public AirportSim(double endClock, List<Server> servers, ServerSelectionPolicy policy,
                      Randomizer randomizer, Reportable report) {
        super(report);
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'run'");
    }
}
