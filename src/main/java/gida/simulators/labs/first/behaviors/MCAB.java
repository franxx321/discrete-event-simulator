package gida.simulators.labs.first.behaviors;

import gida.simulators.labs.first.utils.Randomizer;

public class MCAB implements Behavior {
    /*CDESC Maintenance Crew Arrival Behaviour, extends Behaviour
     *  generates the next time for a maintenance crew arrival */

    Randomizer randomizer;

    public MCAB(Randomizer randomizer) {
        this.randomizer = randomizer;
    }
    @Override
    public double nextTime(double clock) {
        int n = 24;
        double acum = 0;
        for (int i=0 ;i < n; i++){
            acum+= randomizer.nextRandom();
        }
        double zPrime= (acum-(n*0.5))/(Math.sqrt((double) n/12));
        double ret= (zPrime*0.5*1440)+(5*1440);
        return ret;
    }



}
