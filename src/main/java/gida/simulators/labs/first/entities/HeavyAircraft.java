package gida.simulators.labs.first.entities;
import gida.simulators.labs.first.resources.Airstrip;
import gida.simulators.labs.first.resources.Server;
import gida.simulators.labs.first.utils.Randomizer;

import gida.simulators.labs.first.behaviors.ArrivalBehavior;
import gida.simulators.labs.first.behaviors.Behavior;
import gida.simulators.labs.first.behaviors.EndOfServiceBehavior;
import gida.simulators.labs.first.resources.HFA;
import gida.simulators.labs.first.utils.Randomizer;

public class HeavyAircraft extends Aircraft {

    Randomizer randomizer;

    public HeavyAircraft(int id, Behavior arrivalBehavior, Behavior endOfServiceBehavior) {
        super(id,arrivalBehavior,endOfServiceBehavior);
    }

    @Override
    public Entity getNextEntity() {
        HeavyAircraft h = new HeavyAircraft(this.getId()+1,this.getArrivalBehavior(),this.getEndOfServiceBehavior());
        return h;
    }

    @Override
    public void applyEffect(Server server){
        Airstrip airstrip = (Airstrip)server;
        float d = airstrip.getDurability();
        float acum;
        acum = 6 * (float) randomizer.nextRandom();
        d-=acum;
        airstrip.setDurability(d);
    }
}
