package gida.simulators.labs.first.policies;

import gida.simulators.labs.first.entities.Entity;
import gida.simulators.labs.first.entities.MaintenanceCrew;
import gida.simulators.labs.first.resources.Queue;


import java.util.List;

public class OnetoManySameClassQueuePoliciy implements ServerQueuePolicy{
    int potentialMaxQueueSize;

    @Override
    public boolean queuesEmpty(List<Queue> queues) {
        boolean ret=true;
        for (Queue queue:queues){
            if(!(queue.isEmpty())){
                return false;
            }
        }
        return ret;
    }

    @Override
    public void enqueue(List<Queue> queues, Entity entity) {
        if(entity instanceof MaintenanceCrew){
            queues.get(1).enqueue(entity);
            potentialMaxQueueSize=1;
        }
        else{
            queues.get(0).enqueue(entity);
            potentialMaxQueueSize=0;
        }

    }
    @Override
    public Entity dequeue(List<Queue> queues) {
        Entity ret;
        if (!(queues.get(1).isEmpty())){
            ret=queues.get(1).dequeue();
        }
        else{
            ret=queues.get(0).dequeue();
        }
        return ret;
    }



    @Override
    public Queue getLastQueue(List<Queue> queues) {
        Queue ret =queues.get(potentialMaxQueueSize);
        potentialMaxQueueSize=0;
        return ret;
    }
}
