package gida.simulators.labs.first.engine;

import java.util.List;

import gida.simulators.labs.first.behaviors.ArrivalBehavior;
import gida.simulators.labs.first.behaviors.EndOfServiceBehavior;
import gida.simulators.labs.first.entities.Aircraft;
import gida.simulators.labs.first.events.Arrival;
import gida.simulators.labs.first.events.EndOfService;
import gida.simulators.labs.first.events.Event;
import gida.simulators.labs.first.events.StopSimulation;
import gida.simulators.labs.first.policies.ServerSelectionPolicy;
import gida.simulators.labs.first.resources.Server;
import gida.simulators.labs.first.utils.Randomizer;

public class AirportSim extends Engine {

    private FutureEventList fel;
    private List<Server> servers;

    private Randomizer randomizer;

    private ServerSelectionPolicy policy;

    private CustomReport report;

    public AirportSim(double endClock, List<Server> servers, ServerSelectionPolicy policy,
                      Randomizer randomizer, CustomReport report) {
        super();
        this.servers=servers;
        this.randomizer=randomizer;
        this.policy=policy;
        this.report=report;
        this.fel =new FutureEventList();
        this.fel.insert(new StopSimulation(endClock,this));
        Aircraft aircraft=new Aircraft(1);
        Arrival event= new Arrival(0,aircraft,new ArrivalBehavior(randomizer),new EndOfServiceBehavior(randomizer),policy,report);
        aircraft.addEvent(event);
        this.fel.insert(event);
    }

    @Override
    public void run() {
        while (!this.isStop()){
            Event event= this.fel.getImminent();
            event.planificate(this.fel,this.servers);
        }
        while(fel.hasNext()){
            //TODO cambiar esta parte para que funcione con multiples servidores
            Event event= this.fel.getImminent();
            if(event instanceof EndOfService){
                event.planificate(this.fel,this.servers);
                report.setLastClock(event.getClock());
            }
        }
        report.generateReport();
        // TODO Auto-generated method stub
        //throw new UnsupportedOperationException("Unimplemented method 'run'");
    }
}
