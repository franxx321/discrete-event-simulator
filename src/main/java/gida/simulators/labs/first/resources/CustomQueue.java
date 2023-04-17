package gida.simulators.labs.first.resources;

import gida.simulators.labs.first.entities.Entity;
import gida.simulators.labs.first.utils.Order;

import java.util.ArrayList;

public class CustomQueue implements Queue {

    private int id;
    private java.util.ArrayList<Entity> queue;


    public CustomQueue(int id) {
        this.id = id;
        queue = new ArrayList();
    }

    @Override
    public int getId() {
        return this.id;
        // TODO Auto-generated method stub
        //throw new UnsupportedOperationException("Unimplemented method 'getId'");
    }

    @Override
    public boolean isEmpty() {
        return this.queue.isEmpty();
        // TODO Auto-generated method stub
        //throw new UnsupportedOperationException("Unimplemented method 'isEmpty'");
    }

    @Override
    public void enqueue(Entity entity) {
        this.queue.add(entity);
        // TODO Auto-generated method stub
        //throw new UnsupportedOperationException("Unimplemented method 'enqueue'");
    }

    @Override
    public Entity checkNext() {
         return this.queue.get(0);
        // TODO Auto-generated method stub
        //throw new UnsupportedOperationException("Unimplemented method 'checkNext'");
    }

    @Override
    public Entity next() {
        return this.queue.remove(0);
        // TODO Auto-generated method stub
        //throw new UnsupportedOperationException("Unimplemented method 'next'");
    }

    @Override
    public String toString() {
        return "id: " + this.id + " -> " + this.queue.toString();
    }
}
