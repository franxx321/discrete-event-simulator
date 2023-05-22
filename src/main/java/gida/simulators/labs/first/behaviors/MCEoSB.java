package gida.simulators.labs.first.behaviors;

import gida.simulators.labs.first.utils.Randomizer;

public class MCEoSB implements Behavior{
    Randomizer randomizer;

    @Override
    public double nextTime(double clock) {
        double ret = 0;
        ret += 24 * randomizer.nextRandom();
        return ret;
    }

    /*CDESC Maintenance Crew End of Service Behaviour
    *  generates the next time for a maintenance crew end of service */
}
