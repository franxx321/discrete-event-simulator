package gida.simulators.labs.first.events;

import java.util.List;

import gida.simulators.labs.first.behaviors.ArrivalBehavior;
import gida.simulators.labs.first.behaviors.EndOfServiceBehavior;
import gida.simulators.labs.first.engine.CustomReport;
import gida.simulators.labs.first.engine.FutureEventList;
import gida.simulators.labs.first.entities.Aircraft;
import gida.simulators.labs.first.policies.ServerSelectionPolicy;
import gida.simulators.labs.first.resources.Airstrip;
import gida.simulators.labs.first.resources.Server;
import gida.simulators.labs.first.entities.Entity;
import gida.simulators.labs.first.behaviors.Behavior;

public class Arrival extends Event {

    private ServerSelectionPolicy policy;

    private EndOfServiceBehavior endOfServiceBehavior;

    private CustomReport report;




    public Arrival(double clock, Entity entity, Behavior behavior,
                   EndOfServiceBehavior endOfServiceBehavior, ServerSelectionPolicy policy, CustomReport report) {
        super(clock,entity,behavior,2);
        this.endOfServiceBehavior=endOfServiceBehavior;
        this.policy=policy;
        this.report=report;

    }

    @Override
    public void planificate(FutureEventList fel, List<Server> servers) {
        Server server = policy.selectServer(servers);
        if (server.isBusy()) {
            server.enqueue(this.getEntity());
        } else {
            server.setCurrentEntity(this.getEntity());
            this.getEntity().setServer(server);
            double idletime = (this.getClock() - ((Airstrip) server).getLastIdleStartTime());
            if (idletime>report.getMaxIdleTime()){
                report.setMaxIdleTime(idletime);
            }
            report.sumIdletime(idletime);
            fel.insert(new EndOfService((this.getClock() + endOfServiceBehavior.nextTime()), this.getEntity(), endOfServiceBehavior,this.report));
        }
        /*TOASK Esto esta mas raro que la mierda, hay que preguntarle al profe que onda*/
        Aircraft aircraft = new Aircraft(this.getEntity().getId() + 1);
        Arrival event = new Arrival((this.getClock() + this.getBehavior().nextTime()), aircraft, this.getBehavior(), this.endOfServiceBehavior, this.policy,this.report);
        aircraft.addEvent(event);
        fel.insert(event);


    }

    @Override
    public String toString() {
        String ret = "";
        ret += "arrival - entity id: " + this.getEntity().getId() + " - clock: " + this.getClock();
        return ret;
    }
}
