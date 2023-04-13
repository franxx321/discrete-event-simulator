package gida.simulators.labs.first.behaviors;

import gida.simulators.labs.first.utils.Randomizer;
import gida.simulators.labs.first.utils.distributions.Distribution;
import gida.simulators.labs.first.utils.distributions.EmpiricalDiscrete;

public class EndOfServiceBehavior implements Behavior {

    private Randomizer randomizer;
    private Distribution<Double> distribution;

    public EndOfServiceBehavior(Randomizer randomizer) {
        this.randomizer=randomizer;
    }

    /**
     * {@inheritDoc}
     * 
     */
    @Override
    public double nextTime() {
        double ret;
        double r= randomizer.nextRandom();
        if (r<0.1){
            ret=8;
        } else if(r<0.48){
            ret=10;
        } else if (r<0.8) {
            ret=15;
        } else  {
            ret=20;
        }
        return ret;
    }
}
