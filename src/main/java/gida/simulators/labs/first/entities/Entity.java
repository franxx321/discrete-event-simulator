package gida.simulators.labs.first.entities;

import java.util.ArrayList;
import java.util.List;
import gida.simulators.labs.first.events.Arrival;
import gida.simulators.labs.first.events.Event;
import gida.simulators.labs.first.resources.Server;

public abstract class Entity {

    private final int id;

    private Server server;
    private List<Event> events;

    public Entity(int id, Arrival arrival) {
        this.id=id;
        this.events.add(arrival.getOrder(),arrival);
    }

    public int getId() {return id;
    }

    public Server getServer() {
        return this.server;
    }

    public void setServer(Server server) {
        this.server = server;
    }

    public List<Event> getEvents() {
        return this.events;
    }

    //Todo encontrar una forma mas elegante de hacer este evento
    public Event getArrival() {
        Event ret=null;
        for (Event event : events
        ) {
            if (event instanceof Arrival) {
                ret= event;
            }
        }
        return ret;
    }


    public void addEvent(Event event) {
        this.events.add(event.getOrder(), event);
    }
}
