package gida.simulators.labs.first.entities;

import java.util.ArrayList;
import java.util.List;
import gida.simulators.labs.first.events.Arrival;
import gida.simulators.labs.first.events.Event;
import gida.simulators.labs.first.resources.Server;
import gida.simulators.labs.first.utils.Order;

public abstract class Entity {

    private final int id;

    private Server server;
    private List<Event> events;

    Order order;

    public Entity(int id, Arrival arrival) {
        events=new ArrayList<>();
        this.id=id;
        this.events.add(arrival);
        this.order=new Order();
    }

    public Entity(int id) {
        this.id = id;
        events=new ArrayList<>();
        this.order=new Order();
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
        this.events.add(event);
        events.sort(order);
    }
}
