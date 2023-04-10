package gida.simulators.labs.first.events;

import java.util.List;
import gida.simulators.labs.first.behaviors.Behavior;
import gida.simulators.labs.first.engine.FutureEventList;
import gida.simulators.labs.first.entities.Entity;
import gida.simulators.labs.first.resources.Server;

/**
 * This class represents an event in the simulation. It can be built with a behavior that
 * mathematically specifies the occurrence time
 */
public abstract class Event {

    private final double clock;
    private final Entity entity;
    private final int order;

    private final Behavior behavior;

    /**
     * construct the event for the simulation.
     *
     * @param clock the time when it occurs
     * @param entity the entity in which the event occurs
     * @param behavior the behavior that mathematically specifies the occurrence time
     * @param order the value that resolves the order when the occurrence times of two events are
     *        equal
     */
    public Event(double clock, Entity entity, Behavior behavior, int order) {
        this.clock = clock;
        this.entity = entity;
        this.behavior = behavior;
        this.order = order;
    }

    public double getClock() {
        return this.clock;
    }

    public Entity getEntity() {
        return this.entity;
    }

    public int getOrder() {
        return this.order;
    }

    public Behavior getBehavior() {
        return this.behavior;
    }

    /**
     * planificates the next event using the bootstrapring technique
     * 
     * @param fel the future event list.
     * @param servers the servers list that will b
     */
    public abstract void planificate(FutureEventList fel, List<Server> servers);
}
