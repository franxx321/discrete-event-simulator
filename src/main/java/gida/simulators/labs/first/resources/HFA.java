package gida.simulators.labs.first.resources;

import gida.simulators.labs.first.policies.ServerQueuePolicy;

import java.util.List;

public class HFA extends Airstrip {
    public HFA(int id, List<Queue> queues, ServerQueuePolicy serverQueuePolicy) {
        super(id, queues, serverQueuePolicy);
        this.setDurability(5000);
    }
    /*CDESC Heavy Flight Airstrip, extends Airstrip.
    *  Destined for heavy flight planes*/
}
