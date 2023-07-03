package gida.simulators.labs.first;

import gida.simulators.labs.first.engine.AirportSim;
import gida.simulators.labs.first.engine.CustomReport;
import gida.simulators.labs.first.policies.LMHASP;
import gida.simulators.labs.first.policies.OneToOneQueuePolicy;
import gida.simulators.labs.first.policies.TPM3P;
import gida.simulators.labs.first.policies.UniqueServerSelectionPolicy;
import gida.simulators.labs.first.resources.*;
import gida.simulators.labs.first.utils.*;

import java.util.ArrayList;
import java.util.List;

public class App {

    private static final double SIMULATION_LENGHT = 40320;

    private static final int REPLICATION_AMOUNT =50;

    public static void main(String[] args) {
        CustomReport report = new CustomReport(REPLICATION_AMOUNT);
        for (int i =0; i<REPLICATION_AMOUNT; i++){
            List<Server> servers = ScenarioBuilder.LMHA(2,2,1);
            //List<Server> servers = ScenarioBuilder.TPM3(2,4,3);
            AirportSim sim =new AirportSim(SIMULATION_LENGHT,servers,new LMHASP(),new CustomRandomizer(),report, new CustomRandomizer());
            sim.run();
        }
        report.generateReport();

    }
}
