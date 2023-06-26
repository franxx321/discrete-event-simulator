package gida.simulators.labs.first;

import gida.simulators.labs.first.engine.AirportSim;
import gida.simulators.labs.first.engine.CustomReport;
import gida.simulators.labs.first.policies.LMHASP;
import gida.simulators.labs.first.policies.OneToOneQueuePolicy;
import gida.simulators.labs.first.policies.UniqueServerSelectionPolicy;
import gida.simulators.labs.first.resources.*;
import gida.simulators.labs.first.utils.*;

import java.util.ArrayList;
import java.util.List;

public class App {

    private static final double SIMULATION_LENGHT = 40320;

    public static void main(String[] args) {
        List<Server> servers = ScenarioBuilder.LMHA(2,2,2);
        CustomReport report = new CustomReport(50);
        for (int i =0; i<50; i++){
            AirportSim sim =new AirportSim(SIMULATION_LENGHT,servers,new LMHASP(),new CustomRandomizer(),report, new CustomRandomizer());
            sim.run();
        }

    }
}
