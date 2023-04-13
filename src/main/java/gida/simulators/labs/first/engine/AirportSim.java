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
        this.fel =new FutureEventList();
        Aircraft aircraft = null;
        this.fel.insert(new StopSimulation(endClock,this));
        Arrival event= new Arrival(0,aircraft,new ArrivalBehavior(randomizer),new EndOfServiceBehavior(randomizer),policy,report);
        this.fel.insert(event);
        aircraft=new Aircraft(1,  event);

    }

    @Override
    public void run() {
        //Todo terminar de implementar planificate en EoS
        //  ver como hacer la recoleccion de datos(creo que voy a tener que pasar reportable o algo asi)
        while (!this.isStop()){
            Event event= this.fel.getImminent();
            event.planificate(this.fel,this.servers);
        }
        while(fel.hasNext()){
            Event event= this.fel.getImminent();
            if(event instanceof EndOfService){
                event.planificate(this.fel,this.servers);
            }
        }
        report.generateReport();
        // TODO Auto-generated method stub
        //throw new UnsupportedOperationException("Unimplemented method 'run'");
    }
}
