package gida.simulators.labs.first.entities;

public class HeavyAircraft extends Aircraft {

    //TOIMPLEMENT
    public HeavyAircraft(int id) {
        super(id);
    }


    @Override
    public Aircraft getNextAircraft() {
        HeavyAircraft h = new HeavyAircraft(this.getId()+1);
        return h;
    }
}
