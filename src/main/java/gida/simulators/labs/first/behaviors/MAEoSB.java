package gida.simulators.labs.first.behaviors;
import gida.simulators.labs.first.utils.Randomizer;

public class MAEoSB implements Behavior {
    Randomizer randomizer;
    //TOIMPLEMENT

    @Override
    public double nextTime(double clock) {

            double ret = 0;
            int n=24;
            for (int i=0;i<n;i++){
                ret+= 20 * randomizer.nextRandom();
            }

            return ret;
    }
    //CDESC Medium Aircraft End of Service Behaviour, implements End of Service Behaviour
}
