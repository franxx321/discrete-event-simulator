package gida.simulators.labs.first.resources;

import gida.simulators.labs.first.entities.Entity;
import gida.simulators.labs.first.utils.Order;

import java.util.ArrayList;

public class CustomQueue implements Queue {

    private int id;
    private java.util.ArrayList<Entity> queue;


    public CustomQueue(int id) {
        this.id = id;
        queue = new ArrayList<Entity>();
    }

    @Override
    public int getId() {
        return this.id;
    }

    public int getSize(){
        int ret;
        ret=this.queue.size();
        return ret;
    }

    @Override
    public boolean isEmpty() {
        return this.queue.isEmpty();
    }

    @Override
    public void enqueue(Entity entity) {
        this.queue.add(entity);
    }

    @Override
    public Entity checkNext() {
         return this.queue.get(0);

    }

    @Override
    public Entity dequeue() {
        return this.queue.remove(0);
    }

    @Override
    public Entity checkLast() {
        return this.queue.get(this.queue.size()-1);
    }

    @Override
    public String toString() {
        return "id: " + this.id + " -> " + this.queue.toString();
    }
}
