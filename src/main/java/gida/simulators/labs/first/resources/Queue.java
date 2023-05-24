package gida.simulators.labs.first.resources;

import gida.simulators.labs.first.entities.Entity;

public interface Queue {

    int getId();

    int getSize();

    boolean isEmpty();

    void enqueue(Entity entity);

    Entity checkNext();

    Entity dequeue();

    Entity checkLast();
}
