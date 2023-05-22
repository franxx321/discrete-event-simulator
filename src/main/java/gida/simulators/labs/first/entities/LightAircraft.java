package gida.simulators.labs.first.entities;

import gida.simulators.labs.first.behaviors.ArrivalBehavior;
import gida.simulators.labs.first.behaviors.Behavior;
import gida.simulators.labs.first.behaviors.EndOfServiceBehavior;
import gida.simulators.labs.first.resources.Airstrip;
import gida.simulators.labs.first.resources.Server;
import gida.simulators.labs.first.utils.Randomizer;

public class LightAircraft extends Aircraft {
    Randomizer randomizer;
    public LightAircraft(int id, Behavior arrivalBehavior, Behavior endOfServiceBehavior) {
        super(id,arrivalBehavior,endOfServiceBehavior);
    }

    //TOIMPLEMENT
    @Override
    public Aircraft getNextAircraft() {
        LightAircraft l = new LightAircraft(this.getId()+1,this.getArrivalBehavior(),this.getEndOfServiceBehavior());
        return l;
    }

    @Override
    public void applyEffect(Server server){
        Airstrip airstrip = (Airstrip)server;
        float d = airstrip.getDurability();
        float acum;
        acum = (float) randomizer.nextRandom();
        d-=acum;
        airstrip.setDurability(d);
    }




}
