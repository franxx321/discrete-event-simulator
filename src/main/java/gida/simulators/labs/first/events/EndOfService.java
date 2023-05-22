package gida.simulators.labs.first.events;

import java.util.List;
import gida.simulators.labs.first.behaviors.EndOfServiceBehavior;
import gida.simulators.labs.first.engine.CustomReport;
import gida.simulators.labs.first.engine.FutureEventList;
import gida.simulators.labs.first.entities.Aircraft;
import gida.simulators.labs.first.entities.Entity;
import gida.simulators.labs.first.resources.Airstrip;
import gida.simulators.labs.first.resources.Queue;
import gida.simulators.labs.first.resources.Server;

public class EndOfService extends Event {

    private CustomReport report;

    public EndOfService(double clock, Entity entity,  CustomReport report) {
        super(clock,entity,0);
        this.report=report;
    }

    @Override
    public void planificate(FutureEventList fel, List<Server> servers) {
        Server server= this.getEntity().getServer();
        Queue currentQueue= server.getQueue();
        if(currentQueue.isEmpty()){
            server.setCurrentEntity(null);
            ((Airstrip)server).setLastIdleStartTime(this.getClock());
        }
        else{
            Entity currentEntity= currentQueue.dequeue();
            server.setCurrentEntity(currentEntity);
            currentEntity.setServer(server);
            fel.insert(new EndOfService((this.getClock()+((Aircraft)this.getEntity()).getNextEoSTime(this.getClock())),currentEntity,this.report));
            double queuetime = this.getClock() - currentEntity.getArrival().getClock();
            if(queuetime>report.getMaxQueueTime()){
                report.setMaxQueueTime(queuetime);
            }
            report.sumQueuetime(queuetime);
        }

        double transitTime=this.getClock()-this.getEntity().getArrival().getClock();
        report.sumTransitTime(transitTime);
        if(transitTime>report.getMaxTransitTime()){
            report.setMaxTransitTime(transitTime);
        }

        this.getEntity().addEvent(this);
        this.report.addEntityAmount();
    }

    @Override
    public String toString() {
        String ret = "";
        ret += "end of service - entity id: " + this.getEntity().getId() + " - clock: "
                + this.getClock();
        return ret;
    }
}
