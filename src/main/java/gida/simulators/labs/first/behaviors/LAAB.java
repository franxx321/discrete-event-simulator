package gida.simulators.labs.first.behaviors;

import gida.simulators.labs.first.utils.Randomizer;

public class LAAB implements Behavior {
    /*CDESC Light Aircraft Arrival Behaviour, implements behaviour.*/
    Randomizer randomizer;

    public LAAB(Randomizer randomizer) {
        this.randomizer = randomizer;
    }

    @Override
    public double nextTime(double clock) {
        double ret;
        int clock1 = ((int)(clock)) % 1440;
        int n=24;
        if((420 <= clock1 && clock1 <= 600) || (1140 <= clock1 && clock <= 1320)){
            ret= Math.log((1-randomizer.nextRandom()))*-20;
        }else{
            ret= Math.log((1-randomizer.nextRandom()))*-40;
        }
        return ret;
    }

}
