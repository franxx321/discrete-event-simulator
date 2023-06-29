package gida.simulators.labs.first.resources;

import java.util.List;

import gida.simulators.labs.first.entities.MaintenanceCrew;
import gida.simulators.labs.first.policies.ServerQueuePolicy;

public abstract class Airstrip extends Server {

    float durability;

    private final float maxDurability;


    private double lastIdleStartTime;

    public Airstrip(float maxDurability) {
        super();
        this.maxDurability = maxDurability;
    }



    public Airstrip(int id, List<Queue> queues, ServerQueuePolicy serverQueuePolicy, float maxDurability) {
        super(id,queues,serverQueuePolicy);
        this.maxDurability=maxDurability;
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

    public float getDurability() {
        return durability;
    }



    public void setDurability(float durability) {
        this.durability = durability;
    }

    public float getMaxDurability() {
        return maxDurability;
    }


}
