package gida.simulators.labs.first.resources;

import gida.simulators.labs.first.policies.ServerQueuePolicy;

import java.util.List;

public class MFA extends Airstrip {
    /*CDESC Medium Flight Airstrips, extends Airstrip.
    *  Destined for Medium Airplanes*/

    public MFA(int id, List<Queue> queues, ServerQueuePolicy serverQueuePolicy) {
        super(id, queues, serverQueuePolicy,3000);
        this.setDurability(3000);
    }
}
