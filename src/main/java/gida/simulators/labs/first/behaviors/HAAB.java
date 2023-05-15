package gida.simulators.labs.first.behaviors;

import gida.simulators.labs.first.utils.Randomizer;
import java.lang.Math.*;

public class HAAB implements Behavior {
    Randomizer randomizer;

    @Override
    public double nextTime(double clock) {
        double ret;
        int clock1 = ((int)(clock)) % 1440;
        double acum=0;

        int n=24;
        for (int i=0;i<n;i++){
            acum+= randomizer.nextRandom();
        }
        double zPrime= (acum-(n*0.5))/(Math.sqrt((double) n/12));

        if((420 <= clock1 && clock1 <= 600) || (1140 <= clock1 && clock <= 1320)){
            ret= zPrime*2+30;
        } else{
            ret= zPrime*2+60;
        }

        return ret;
    }

    /*CDESC Heavy Aircraft Arrival Behaviour, implements behaviour.*/
}
