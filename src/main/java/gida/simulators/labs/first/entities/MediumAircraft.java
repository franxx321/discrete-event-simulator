package gida.simulators.labs.first.entities;

import gida.simulators.labs.first.behaviors.Behavior;

public class MediumAircraft  extends Aircraft{
    public MediumAircraft(int id, Behavior arrivalBehaviour, Behavior endOfServiceBehaviour) {
        super(id,arrivalBehaviour,endOfServiceBehaviour);
    }

    //TOIMPLEMENT

    @Override
    public Aircraft getNextAircraft() {
        MediumAircraft m = new MediumAircraft(this.getId()+1,this.getArrivalBehavior(),this.getEndOfServiceBehavior());
        return m;
    }



}
