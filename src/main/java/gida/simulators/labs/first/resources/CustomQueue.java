package gida.simulators.labs.first.resources;

import gida.simulators.labs.first.entities.Entity;

public class CustomQueue implements Queue {

    private int id;
    private java.util.Queue<Entity> queue;

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
         return this.queue.peek();
        // TODO Auto-generated method stub
        //throw new UnsupportedOperationException("Unimplemented method 'checkNext'");
    }

    @Override
    public Entity next() {
        return this.queue.remove();
        // TODO Auto-generated method stub
        //throw new UnsupportedOperationException("Unimplemented method 'next'");
    }

    @Override
    public String toString() {
        return "id: " + this.id + " -> " + this.queue.toString();
    }
}
