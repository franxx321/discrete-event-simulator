package gida.simulators.labs.first.events;

import java.util.List;
import gida.simulators.labs.first.engine.AirportSim;
import gida.simulators.labs.first.engine.Engine;
import gida.simulators.labs.first.engine.FutureEventList;
import gida.simulators.labs.first.resources.Server;

public class StopSimulation extends Event {

    private Engine engine;

    private final int ORDER=1;

    public StopSimulation(double clock, AirportSim engine) {
        super(clock, null, 1);
        this.engine=engine;

    }

    @Override
    public void planificate(FutureEventList fel, List<Server> servers) {
        this.engine.stopExecute();
    }

    @Override
    public String toString() {
        String ret = "";
        ret += "Stop Simulation - entity id: null - clock: " + this.getClock();
        return ret;
    }
}
