package gida.simulators.labs.first.entities;

import gida.simulators.labs.first.behaviors.ArrivalBehavior;
import gida.simulators.labs.first.behaviors.Behavior;
import gida.simulators.labs.first.behaviors.EndOfServiceBehavior;
import gida.simulators.labs.first.events.Arrival;
import gida.simulators.labs.first.resources.Airstrip;

public abstract class Aircraft extends Entity {



    public Aircraft(int id, Arrival arrival) {
        super(id, arrival);
    }
    public Aircraft(int id, Behavior arrivalBehavior, Behavior endOfServiceBehavior){
        super(id,arrivalBehavior,endOfServiceBehavior);

    }

    public abstract  Aircraft getNextAircraft();


    @Override
    public String toString() {
        return "type: aircraft - id: " + this.getId();
    }
}
