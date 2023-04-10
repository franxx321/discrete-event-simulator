package gida.simulators.labs.first.entities;

import gida.simulators.labs.first.events.Arrival;

public class Aircraft extends Entity {

    public Aircraft(int id, Arrival arrival) {
        super(id, arrival);
    }

    @Override
    public String toString() {
        return "type: aircraft - id: " + this.getId();
    }
}
