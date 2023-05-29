package gida.simulators.labs.first.events;

import java.util.List;
import gida.simulators.labs.first.behaviors.ArrivalBehavior;
import gida.simulators.labs.first.behaviors.EndOfServiceBehavior;
import gida.simulators.labs.first.engine.CustomReport;
import gida.simulators.labs.first.engine.FutureEventList;
import gida.simulators.labs.first.engine.Reportable;
import gida.simulators.labs.first.entities.Aircraft;
import gida.simulators.labs.first.policies.ServerSelectionPolicy;
import gida.simulators.labs.first.resources.Airstrip;
import gida.simulators.labs.first.resources.Queue;
import gida.simulators.labs.first.resources.Server;
import gida.simulators.labs.first.entities.Entity;
import gida.simulators.labs.first.behaviors.Behavior;

public class Arrival extends Event {

    private ServerSelectionPolicy policy;


    private Reportable report;




    public Arrival(double clock, Entity entity,
            ServerSelectionPolicy policy, Reportable report) {
        super(clock,entity,2);
        this.policy=policy;
        this.report=report;
    }

    @Override
    public void planificate(FutureEventList fel, List<Server> servers) {
        Server server = policy.selectServer(servers,this.getEntity());
        if (server.isBusy()) {
            Queue currentqueue=server.getQueue();
            currentqueue.enqueue(this.getEntity());
            this.report.calculateQueueLength(currentqueue);
        } else {
            server.setCurrentEntity(this.getEntity());
            this.getEntity().setServer(server);
            double idletime = (this.getClock() - ((Airstrip) server).getLastIdleStartTime());
            this.report.calculateIdleTime(server,this);
            fel.insert(new EndOfService((this.getClock() + ((Aircraft)this.getEntity()).getNextEoSTime(this.getClock())), this.getEntity(), this.report));
        }
        Entity newEntity =this.getEntity().getNextEntity();
        Arrival event = new Arrival((this.getClock() + ((Aircraft)this.getEntity()).getNextArrivalTime(this.getClock())), newEntity, this.policy,this.report);
        newEntity.addEvent(event);
        fel.insert(event);
    }

    @Override
    public String toString() {
        String ret = "";
        ret += "arrival - entity id: " + this.getEntity().getId() + " - clock: " + this.getClock();
        return ret;
    }
}
