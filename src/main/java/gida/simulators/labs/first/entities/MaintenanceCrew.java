package gida.simulators.labs.first.entities;

import gida.simulators.labs.first.behaviors.Behavior;
import gida.simulators.labs.first.resources.Airstrip;
import gida.simulators.labs.first.resources.Server;

public class MaintenanceCrew extends Entity{
    public MaintenanceCrew(int id, Behavior arrivalBehavior, Behavior endOfServiceBehavior) {
        super(id, arrivalBehavior, endOfServiceBehavior);
    }

    @Override
    public void applyEffect(Server server) {
        Airstrip airstrip =(Airstrip)server;
        airstrip.setDurability((float)((airstrip.getMaxDurability()*0.15)+airstrip.getDurability()));
    }

    public Entity getNextEntity(){
        MaintenanceCrew m = new MaintenanceCrew(this.getId()+1, this.getArrivalBehavior(), this.getEndOfServiceBehavior());
        return m;
    }
}
