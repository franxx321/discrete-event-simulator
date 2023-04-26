package gida.simulators.labs.first.utils;

import java.util.ArrayList;

public class CustomArrivalTestingRandomizer extends CustomTestingRandomizer{


    public CustomArrivalTestingRandomizer(int a){
        super();
        ArrayList<Double> rand= this.getRandoms();
        if(a==1){
            for (int i = 0; i <10 ; i++) {
                rand.add(0.2);
            }
        } else if (a==2) {
            for (int i = 0; i <10 ; i++) {
                rand.add(0.5);
            }
        } else if (a==3) {
            for (int i = 0; i <10 ; i++) {
                rand.add(0.2);
            }
        }

    }


    @Override
    public double nextRandom() {
        double ret =this.getRandoms().get(this.getCounter());
        this.sumCounter();
        return ret;

    }
}
