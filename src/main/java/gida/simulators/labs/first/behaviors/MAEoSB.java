package gida.simulators.labs.first.behaviors;
import gida.simulators.labs.first.utils.Randomizer;

public class MAEoSB implements Behavior {
    //CDESC Medium Aircraft End of Service Behaviour, implements End of Service Behaviour
    Randomizer randomizer;

    public MAEoSB(Randomizer randomizer) {
        this.randomizer = randomizer;
    }

    @Override
    public double nextTime(double clock) {
            double ret =0;
            ret+= (10 * randomizer.nextRandom())+10;
            return ret;
    }

}
