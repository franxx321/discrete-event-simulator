package gida.simulators.labs.first.resources;

import gida.simulators.labs.first.policies.ServerQueuePolicy;

import java.util.List;

public class LFA extends Airstrip {
    /*CDESC Light Flight Airstrip, implements Airstrip.
    *  Destined for heavy flight airplanes*/

    public LFA(int id, List<Queue> queues, ServerQueuePolicy serverQueuePolicy) {
        super(id, queues, serverQueuePolicy,1000);
        this.setDurability(1000);
    }
}
