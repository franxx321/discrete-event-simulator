package gida.simulators.labs.first.policies;

import java.util.List;
import gida.simulators.labs.first.entities.Entity;
import gida.simulators.labs.first.resources.Queue;

public class OneToOneQueuePolicy implements ServerQueuePolicy {

    @Override
    public boolean queuesEmpty(List<Queue> queues) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'queuesEmpty'");
    }

    @Override
    public void enqueue(List<Queue> queues, Entity entity) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'enqueue'");
    }

    @Override
    public Entity dequeue(List<Queue> queues) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'dequeue'");
    }
}
