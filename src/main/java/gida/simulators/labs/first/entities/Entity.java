package gida.simulators.labs.first.entities;

import java.util.ArrayList;
import java.util.List;

import gida.simulators.labs.first.behaviors.Behavior;
import gida.simulators.labs.first.events.Arrival;
import gida.simulators.labs.first.events.Event;
import gida.simulators.labs.first.resources.Server;
import gida.simulators.labs.first.utils.Order;

public abstract class Entity {

    private final int id;

    private Server server;
    private List<Event> events;
    private Behavior arrivalBehavior;
    private Behavior endOfServiceBehavior;

    Order order;

    public Entity(int id, Arrival arrival) {
        events=new ArrayList<>();
        this.id=id;
        this.events.add(arrival);
        this.order=new Order();
    }
    public Entity(int id, Behavior arrivalBehavior, Behavior endOfServiceBehavior){
        events=new ArrayList<>();
        this.id=id;
        this.order=new Order();
        this.arrivalBehavior=arrivalBehavior;
        this.endOfServiceBehavior=endOfServiceBehavior;
    }

    public abstract Entity getNextEntity();

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


    public  double getNextArrivalTime(double clock){
        double ret = this.arrivalBehavior.nextTime( clock);
        return ret;
    }

    public  double getNextEoSTime(double clock){
        double ret=this.endOfServiceBehavior.nextTime(clock);
        System.out.println("HERE!");
        return ret;
    }

    public Behavior getArrivalBehavior() {
        return arrivalBehavior;
    }

    public void setArrivalBehavior(Behavior arrivalBehavior) {
        this.arrivalBehavior = arrivalBehavior;
    }

    public Behavior getEndOfServiceBehavior() {
        return endOfServiceBehavior;
    }

    public void setEndOfServiceBehavior(Behavior endOfServiceBehavior) {
        this.endOfServiceBehavior = endOfServiceBehavior;
    }

    public abstract void applyEffect(Server server);

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
