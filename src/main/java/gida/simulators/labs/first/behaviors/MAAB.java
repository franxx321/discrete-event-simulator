package gida.simulators.labs.first.behaviors;

import gida.simulators.labs.first.utils.Randomizer;

public class MAAB implements Behavior {
    Randomizer randomizer;

    @Override
    public double nextTime(double clock) {
        double ret;
        int clock1 = ((int)(clock)) % 1440;
        int n=24;
        if((420 <= clock1 && clock1 <= 600) || (1140 <= clock1 && clock <= 1320)){
            ret= Math.log((1-randomizer.nextRandom())/0.0667);
        }else{
            ret= Math.log((1-randomizer.nextRandom())/0.0333);
        }
        return ret;
    }
    /*CDESC Medium Aircraft Arrival Behaviour, implements behaviour.*/
}
