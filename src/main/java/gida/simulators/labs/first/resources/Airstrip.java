package gida.simulators.labs.first.resources;

import java.util.List;
import gida.simulators.labs.first.policies.ServerQueuePolicy;

public class Airstrip extends Server {

    private double lastIdleStartTime;

    public Airstrip() {
        super();
    }

    public Airstrip(int id, List<Queue> queues, ServerQueuePolicy serverQueuePolicy) {
        super(id,queues,serverQueuePolicy);

    }

    public double getLastIdleStartTime() {
        return lastIdleStartTime;
    }

    public void setLastIdleStartTime(double lastIdleStartTime) {
        this.lastIdleStartTime = lastIdleStartTime;
    }

    @Override
    public String toString() {
        String ret = super.toString();

        ret += "type: airstrip";

        return ret;
    }
}
