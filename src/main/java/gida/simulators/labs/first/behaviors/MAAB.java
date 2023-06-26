package gida.simulators.labs.first.behaviors;

import gida.simulators.labs.first.utils.Randomizer;

public class MAAB implements Behavior {

    /*CDESC Medium Aircraft Arrival Behaviour, implements behaviour.*/
    Randomizer randomizer;

    public MAAB(Randomizer randomizer) {
        this.randomizer = randomizer;
    }

    @Override
    public double nextTime(double clock) {
        double ret;
        int clock1 = ((int)(clock)) % 1440;
        if((420 <= clock1 && clock1 <= 600) || (1140 <= clock1 && clock <= 1320)){
            ret= Math.log((1-randomizer.nextRandom()))*-15;
        }else{
            ret= Math.log((1-randomizer.nextRandom()))*-30;
        }
        return ret;
    }
}
