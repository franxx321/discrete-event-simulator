package gida.simulators.labs.first.entities;

import gida.simulators.labs.first.behaviors.ArrivalBehavior;
import gida.simulators.labs.first.behaviors.Behavior;
import gida.simulators.labs.first.behaviors.EndOfServiceBehavior;
import gida.simulators.labs.first.events.Arrival;
import gida.simulators.labs.first.resources.Airstrip;

public abstract class Aircraft extends Entity {

    private Behavior arrivalBehavior;
    private Behavior endOfServiceBehavior;

    public Aircraft(int id, Arrival arrival) {
        super(id, arrival);
    }
    public Aircraft(int id, Behavior arrivalBehavior, Behavior endOfServiceBehavior){
        super(id);
        this.arrivalBehavior=arrivalBehavior;
        this.endOfServiceBehavior=endOfServiceBehavior;
    }

    public abstract  Aircraft getNextAircraft();

    public  double getNextArrivalTime(double clock){
       double ret = this.arrivalBehavior.nextTime( clock);
       return ret;
    }

    public  double getNextEoSTime(double clock){
        double ret=this.endOfServiceBehavior.nextTime(clock);
        return ret;


    }

    public Behavior getArrivalBehavior() {
        return arrivalBehavior;
    }

    public void setArrivalBehavior(ArrivalBehavior arrivalBehavior) {
        this.arrivalBehavior = arrivalBehavior;
    }

    public Behavior getEndOfServiceBehavior() {
        return endOfServiceBehavior;
    }

    public void setEndOfServiceBehavior(EndOfServiceBehavior endOfServiceBehavior) {
        this.endOfServiceBehavior = endOfServiceBehavior;
    }

    public abstract void applyWhere(Airstrip airstrip);

    @Override
    public String toString() {
        return "type: aircraft - id: " + this.getId();
    }
}
