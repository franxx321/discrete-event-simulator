package gida.simulators.labs.first.engine;

import java.util.List;

import gida.simulators.labs.first.behaviors.*;
import gida.simulators.labs.first.entities.Aircraft;
import gida.simulators.labs.first.entities.HeavyAircraft;
import gida.simulators.labs.first.entities.LightAircraft;
import gida.simulators.labs.first.entities.MediumAircraft;
import gida.simulators.labs.first.events.Arrival;
import gida.simulators.labs.first.events.EndOfService;
import gida.simulators.labs.first.events.Event;
import gida.simulators.labs.first.events.StopSimulation;
import gida.simulators.labs.first.policies.ServerSelectionPolicy;
import gida.simulators.labs.first.resources.Airstrip;
import gida.simulators.labs.first.resources.Server;
import gida.simulators.labs.first.utils.Randomizer;

public class AirportSim extends Engine {

    private FutureEventList fel;
    private List<Server> servers;

    //private Randomizer randomizer;

    private ServerSelectionPolicy policy;

    private CustomReport report;

    double endClock;


  /*  public AirportSim(double endClock, List<Server> servers, ServerSelectionPolicy policy,
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
        this.endClock=endClock;
    }*/

    public AirportSim(double endClock, List<Server> servers, ServerSelectionPolicy policy,
                      Randomizer arrivalRandomizer, CustomReport report, Randomizer endOfServiceRandomizer) {
        super();
        this.servers=servers;
        //this.randomizer=arrivalRandomizer;
        this.policy=policy;
        this.report=report;
        this.fel =new FutureEventList();
        this.fel.insert(new StopSimulation(endClock,this));
        Aircraft aircraft=new LightAircraft(1, new LAAB(),new LAEoSB());
        Arrival event= new Arrival(0,aircraft,policy,report);
        aircraft.addEvent(event);
        this.fel.insert(event);
        //TODO Change behaviors
        Aircraft aircraft1 = new MediumAircraft(2,new MAAB(),new MAEoSB());
        Arrival event1= new Arrival(0, aircraft1, policy, report);
        aircraft1.addEvent(event1);
        this.fel.insert(event1);
        Aircraft aircraft2 = new HeavyAircraft(3,new HAAB(), new HAEoSB());
        Arrival event2 = new Arrival(0, aircraft2, policy, report);
        aircraft2.addEvent(event2);
        this.fel.insert(event2);
        this.endClock=endClock;
    }

    private void sumRemainingIdleTime(List<Server> servers,CustomReport report,double endClock){
        for (Server server:servers) {
            if(!(server.isBusy())){
                double idleTime= (endClock-((Airstrip)server).getLastIdleStartTime());
                report.sumIdletime(idleTime);
                if (idleTime>report.getMaxIdleTime()){
                    report.setMaxIdleTime(idleTime);
                }
            }
        }
    }

    @Override
    public void run() {
        while (!this.isStop()){
            Event event= this.fel.getImminent();
            event.planificate(this.fel,this.servers);
        }
        report.setLastClock(endClock);
        sumRemainingIdleTime(servers,report,endClock);
        while(fel.hasNext()){
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
