package gida.simulators.labs.first.utils;

import java.util.ArrayList;
import java.util.List;

import gida.simulators.labs.first.policies.LMHASP;
import gida.simulators.labs.first.policies.OneToOneQueuePolicy;
import gida.simulators.labs.first.policies.OnetoManySameClassQueuePoliciy;
import gida.simulators.labs.first.policies.ServerQueuePolicy;
import gida.simulators.labs.first.resources.*;

public class ScenarioBuilder {

   // public static List<Server> OneServerOneQueue() {}

   // public static List<Server> OneServerMultipleQueues(int queuesQuantity) {}

    public static List<Server> TPM3(int hquantity, int mquantity, int lquantity) {
        ArrayList<Server> servers = new ArrayList<>();
        int j=1;

        ServerQueuePolicy queuePolicy = new OnetoManySameClassQueuePoliciy();
        Queue heavyQueue = new CustomQueue(1);
        for (int i =0; i<hquantity ;i++){
            ArrayList<Queue> queues = new ArrayList<>();
            queues.add(heavyQueue);
            queues.add(new CustomQueue(j));
            servers.add(new HFA(j,queues,queuePolicy));
            j++;
        }
        Queue mediumQueue = new CustomQueue(2);
        for ( int i=0;i<mquantity;i++){
            ArrayList<Queue> queues = new ArrayList<>();
            queues.add(mediumQueue);
            queues.add(new CustomQueue(j));
            servers.add(new MFA(j,queues,queuePolicy));
            j++;
        }
        Queue lightQueue = new CustomQueue(3);
        for ( int i=0;i<lquantity;i++){
            ArrayList<Queue> queues = new ArrayList<>();
            queues.add(lightQueue);
            queues.add(new CustomQueue(j));
            servers.add(new LFA(j,queues,queuePolicy));
            j++;
        }
        return servers;
    }

    public static List<Server> LMHA(int hquantity, int mquantity, int lquantity){
        ArrayList<Server> servers = new ArrayList<>();
        int j=1;
        ServerQueuePolicy queuePolicy = new OneToOneQueuePolicy();
        for (int i =0; i<hquantity ;i++){
            ArrayList<Queue> queues = new ArrayList<>();
            queues.add(new CustomQueue(j));
            servers.add(new HFA(j,queues,queuePolicy));
            j++;
        }
        for (int i=0 ;i<mquantity; i++){
            ArrayList<Queue> queues = new ArrayList<>();
            queues.add(new CustomQueue(j));
            servers.add(new MFA(j,queues,queuePolicy));
            j++;
        }
        for (int i=0; i<lquantity; i++){
            ArrayList<Queue> queues = new ArrayList<>();
            queues.add(new CustomQueue(j));
            servers.add(new LFA(j,queues,queuePolicy));
            j++;
        }
        return servers;
    }
}
