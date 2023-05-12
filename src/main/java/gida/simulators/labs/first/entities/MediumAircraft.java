package gida.simulators.labs.first.entities;

public class MediumAircraft  extends Aircraft{
    public MediumAircraft(int id) {
        super(id);
    }

    //TOIMPLEMENT

    @Override
    public Aircraft getNextAircraft() {
        MediumAircraft m = new MediumAircraft(this.getId()+1);
        return m;
    }
}
