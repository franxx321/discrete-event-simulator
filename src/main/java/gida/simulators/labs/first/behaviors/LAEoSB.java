package gida.simulators.labs.first.behaviors;

import gida.simulators.labs.first.utils.Randomizer;

public class LAEoSB implements Behavior {

    //CDESC Light Aircraft End of Service Behaviour, implements End of Service Behaviour

    Randomizer randomizer;

    public LAEoSB(Randomizer randomizer) {
        this.randomizer = randomizer;
    }

    //TOIMPLEMENT
    @Override
    public double nextTime(double clock) {
        double random= randomizer.nextRandom();
        double ret;
        if(random<=0.363){
            ret=5;
        } else if (random<=0.838) {
            ret=10;
        }
        else {
            ret=15;
        }
        return ret ;
    }
}
