package gida.simulators.labs.first.policies;

import java.util.List;
import gida.simulators.labs.first.entities.Entity;
import gida.simulators.labs.first.resources.Queue;

public class OneToManyQueuePolicy implements ServerQueuePolicy {

    @Override
    public boolean queuesEmpty(List<Queue> queues) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void enqueue(List<Queue> queues, Entity entity) {
        // TODO Auto-generated method stub

    }

    @Override
    public Entity dequeue(List<Queue> queues) {
        // TODO Auto-generated method stub
        return null;
    }

}
