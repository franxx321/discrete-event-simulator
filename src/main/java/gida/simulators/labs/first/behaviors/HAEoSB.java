package gida.simulators.labs.first.behaviors;

import gida.simulators.labs.first.utils.Randomizer;

public class HAEoSB implements Behavior {
    //CDESC Heavy Aircraft End of Service Behaviour, implements End of Service Behaviour
    Randomizer randomizer;

    public HAEoSB(Randomizer randomizer) {
        this.randomizer = randomizer;
    }

    @Override
    public double nextTime(double clock) {
        double random = randomizer.nextRandom();
        double ret;
        if(random < 0.65){
            ret = 40;
        } else {
            ret = 50;
        }
        return ret;
    }


}
