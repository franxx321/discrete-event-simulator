package gida.simulators.labs.first.events;

import java.util.List;
import gida.simulators.labs.first.behaviors.EndOfServiceBehavior;
import gida.simulators.labs.first.engine.FutureEventList;
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

    }

    @Override
    public String toString() {
        String ret = "";
        ret += "arrival - entity id: " + this.getEntity().getId() + " - clock: " + this.getClock();
        return ret;
    }
}
