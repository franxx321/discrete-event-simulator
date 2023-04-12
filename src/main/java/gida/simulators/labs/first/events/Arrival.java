package gida.simulators.labs.first.events;

import java.util.List;

import gida.simulators.labs.first.behaviors.ArrivalBehavior;
import gida.simulators.labs.first.behaviors.EndOfServiceBehavior;
import gida.simulators.labs.first.engine.FutureEventList;
import gida.simulators.labs.first.entities.Aircraft;
import gida.simulators.labs.first.policies.ServerSelectionPolicy;
import gida.simulators.labs.first.resources.Server;
import gida.simulators.labs.first.entities.Entity;
import gida.simulators.labs.first.behaviors.Behavior;

public class Arrival extends Event {

    private ServerSelectionPolicy policy;

    private EndOfServiceBehavior endOfServiceBehavior;




    public Arrival(double clock, Entity entity, Behavior behavior,
            EndOfServiceBehavior endOfServiceBehavior, ServerSelectionPolicy policy) {
        super(clock,entity,behavior,2);
        this.endOfServiceBehavior=endOfServiceBehavior;
        this.policy=policy;

    }

    @Override
    public void planificate(FutureEventList fel, List<Server> servers) {
        Server server = policy.selectServer(servers);
        if (server.isBusy()) {
            server.enqueue(this.getEntity());
        } else {
            server.setCurrentEntity(this.getEntity());
            fel.insert(new EndOfService((this.getClock() + endOfServiceBehavior.nextTime()), this.getEntity(), endOfServiceBehavior));
        }
        /*TOASK Esto esta mas raro que la mierda, hay que preguntarle al profe que onda*/
        Aircraft aircraft = null;
        Arrival event = new Arrival((this.getClock() + this.getBehavior().nextTime()), aircraft, this.getBehavior(), endOfServiceBehavior, policy);
        aircraft = new Aircraft(this.getEntity().getId() + 1, event);
        fel.insert(event);

    }

    @Override
    public String toString() {
        String ret = "";
        ret += "arrival - entity id: " + this.getEntity().getId() + " - clock: " + this.getClock();
        return ret;
    }
}
