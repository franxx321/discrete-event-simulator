package gida.simulators.labs.first.events;

import java.util.List;
import gida.simulators.labs.first.behaviors.EndOfServiceBehavior;
import gida.simulators.labs.first.engine.FutureEventList;
import gida.simulators.labs.first.entities.Entity;
import gida.simulators.labs.first.resources.Server;

public class EndOfService extends Event {

    public EndOfService(double clock, Entity entity, EndOfServiceBehavior behavior) {
        super(clock,entity,behavior,0);
    }

    @Override
    public void planificate(FutureEventList fel, List<Server> servers) {
        if(this.getEntity().getServer().queuesEmpty()){
            this.getEntity().getServer().setCurrentEntity(null);
        }
        else{
            Entity currentEntity= this.getEntity().getServer().dequeue();
            this.getEntity().getServer().setCurrentEntity(currentEntity);
            fel.insert(new EndOfService(+this.getBehavior().nextTime(),currentEntity,(EndOfServiceBehavior)this.getBehavior()));
        }
    }

    @Override
    public String toString() {
        String ret = "";
        ret += "end of service - entity id: " + this.getEntity().getId() + " - clock: "
                + this.getClock();
        return ret;
    }
}
