package gida.simulators.labs.first.behaviors;

import gida.simulators.labs.first.utils.Randomizer;

public class MCEoSB implements Behavior{
    /*CDESC Maintenance Crew End of Service Behaviour
     *  generates the next time for a maintenance crew end of service */
    Randomizer randomizer;

    public MCEoSB(Randomizer randomizer) {
        this.randomizer = randomizer;
    }

    @Override
    public double nextTime(double clock) {
        double ret = 0;
        ret += ((12*60) * randomizer.nextRandom())+12*60;
        return ret;
    }
}
