package gida.simulators.labs.first.entities;

public class LightAircraft extends Aircraft {
    public LightAircraft(int id) {
        super(id);
    }

    //TOIMPLEMENT
    @Override
    public Aircraft getNextAircraft() {
        LightAircraft l = new LightAircraft(this.getId()+1);
        return l;
    }
}
