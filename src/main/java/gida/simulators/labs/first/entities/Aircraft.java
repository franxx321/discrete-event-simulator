package gida.simulators.labs.first.entities;

import gida.simulators.labs.first.events.Arrival;

public class Aircraft extends Entity {

    public Aircraft(int id, Arrival arrival) {
        super(id, arrival);
    }

    public Aircraft(int id){
        super(id);
    }

    @Override
    public String toString() {
        return "type: aircraft - id: " + this.getId();
    }
}
