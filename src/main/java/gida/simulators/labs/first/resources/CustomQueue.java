package gida.simulators.labs.first.resources;

import gida.simulators.labs.first.entities.Entity;

public class CustomQueue implements Queue {

    private int id;
    private java.util.Queue<Entity> queue;

    @Override
    public int getId() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getId'");
    }

    @Override
    public boolean isEmpty() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isEmpty'");
    }

    @Override
    public void enqueue(Entity entity) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'enqueue'");
    }

    @Override
    public Entity checkNext() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'checkNext'");
    }

    @Override
    public Entity next() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'next'");
    }

    @Override
    public String toString() {
        return "id: " + this.id + " -> " + this.queue.toString();
    }
}
