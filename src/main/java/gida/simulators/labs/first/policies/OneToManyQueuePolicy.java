package gida.simulators.labs.first.policies;

import java.util.List;
import gida.simulators.labs.first.entities.Entity;
import gida.simulators.labs.first.resources.Queue;

public class OneToManyQueuePolicy implements ServerQueuePolicy {

  /*  @Override
    public boolean queuesEmpty(List<Queue> queues) {
        return false;
    }*/

   /* @Override
    public void enqueue(List<Queue> queues, Entity entity) {
    }*/

    /*@Override
    public Entity dequeue(List<Queue> queues) {
        // TODO Auto-generated method stub
        return null;
    }*/

    @Override
    public Queue getQueue(List<Queue> queues) {
        return null;
    }
}
