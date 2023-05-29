package gida.simulators.labs.first.utils;

import java.util.ArrayList;
import java.util.List;

import gida.simulators.labs.first.policies.LMHASP;
import gida.simulators.labs.first.policies.OneToOneQueuePolicy;
import gida.simulators.labs.first.policies.ServerQueuePolicy;
import gida.simulators.labs.first.resources.*;

public class ScenarioBuilder {

   // public static List<Server> OneServerOneQueue() {}

   // public static List<Server> OneServerMultipleQueues(int queuesQuantity) {}

  //  public static List<Server> multipleServersOneQueue(int queuesQuantity) {}

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
