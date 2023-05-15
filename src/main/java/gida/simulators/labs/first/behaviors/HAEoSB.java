package gida.simulators.labs.first.behaviors;

public class HAEoSB implements Behavior {

    //TOIMPLEMENT
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
    //CDESC Heavy Aircraft End of Service Behaviour, implements End of Service Behaviour
}
