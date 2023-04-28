package gida.simulators.labs.first;

import gida.simulators.labs.first.engine.AirportSim;
import gida.simulators.labs.first.engine.CustomReport;
import gida.simulators.labs.first.policies.OneToOneQueuePolicy;
import gida.simulators.labs.first.policies.UniqueServerSelectionPolicy;
import gida.simulators.labs.first.resources.Airstrip;
import gida.simulators.labs.first.resources.CustomQueue;
import gida.simulators.labs.first.resources.Queue;
import gida.simulators.labs.first.resources.Server;
import gida.simulators.labs.first.utils.CustomArrivalTestingRandomizer;
import gida.simulators.labs.first.utils.CustomEoSTestingRandomizer;
import gida.simulators.labs.first.utils.CustomRandomizer;
import gida.simulators.labs.first.utils.CustomTestingRandomizer;

import java.util.ArrayList;

public class App {

    private static final double SIMULATION_LENGHT = 100;

    public static void main(String[] args) {
        ArrayList<Server> servers =new ArrayList<>();
        ArrayList<Queue> queues =new ArrayList<>();
        queues.add(0,new CustomQueue(1));
        servers.add(0,new Airstrip(1,queues,new OneToOneQueuePolicy()));
        AirportSim sim =new AirportSim(SIMULATION_LENGHT,servers,new UniqueServerSelectionPolicy(),new CustomArrivalTestingRandomizer(3),new CustomReport(), new CustomEoSTestingRandomizer(3));
        sim.run();
    }
}
