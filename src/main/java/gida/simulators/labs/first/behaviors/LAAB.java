package gida.simulators.labs.first.behaviors;

public class LAAB implements Behavior {

    //TOIMPLEMENT
    @Override
    public double nextTime(double clock) {
        double ret;
        int clock1 = ((int)(clock)) % 1440;
        int n=24;
        if((420 <= clock1 && clock1 <= 600) || (1140 <= clock1 && clock <= 1320)){
            ret= Math.log((1-randomizer.nextRandom())/0.05);
        }else{
            ret= Math.log((1-randomizer.nextRandom())/0.0025);
        }
        return ret;
    }
    /*CDESC Light Aircraft Arrival Behaviour, implements behaviour.*/
}
