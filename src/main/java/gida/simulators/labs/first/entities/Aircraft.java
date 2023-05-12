package gida.simulators.labs.first.entities;

import gida.simulators.labs.first.events.Arrival;

public abstract class Aircraft extends Entity {

    public Aircraft(int id, Arrival arrival) {
        super(id, arrival);
    }
    public Aircraft(int id){
        super(id);
    }

    public abstract  Aircraft getNextAircraft();

    @Override
    public String toString() {
        return "type: aircraft - id: " + this.getId();
    }
}
