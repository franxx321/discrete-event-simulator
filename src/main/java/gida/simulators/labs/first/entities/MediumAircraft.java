package gida.simulators.labs.first.entities;

import gida.simulators.labs.first.behaviors.Behavior;
import gida.simulators.labs.first.resources.Airstrip;
import gida.simulators.labs.first.resources.Server;
import gida.simulators.labs.first.utils.Randomizer;

public class MediumAircraft extends Aircraft{
    Randomizer randomizer;
    public MediumAircraft(int id, Behavior arrivalBehaviour, Behavior endOfServiceBehaviour) {
        super(id,arrivalBehaviour,endOfServiceBehaviour);
    }

    //TOIMPLEMENT

    @Override
    public Entity getNextEntity() {
        MediumAircraft m = new MediumAircraft(this.getId()+1,this.getArrivalBehavior(),this.getEndOfServiceBehavior());
        return m;
    }

    @Override
    public void applyEffect(Server server){
        Airstrip airstrip = (Airstrip)server;
        float d = airstrip.getDurability();
        float acum;
        acum = 4 * (float) randomizer.nextRandom();
        d-=acum;
        airstrip.setDurability(d);
    }

}
