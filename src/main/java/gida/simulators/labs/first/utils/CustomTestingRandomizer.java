package gida.simulators.labs.first.utils;
import java.util.ArrayList;

public class CustomTestingRandomizer implements Randomizer {

    private ArrayList<Double> randoms;

    private int counter;

    public CustomTestingRandomizer(int a){
        randoms=new ArrayList<>();
        this.counter=0;
        if(a==1){
            for (int i = 0; i <10 ; i++) {
                randoms.add(0.4);
                randoms.add(0.2);
            }
        } else if (a==2) {
            randoms.add(0.4);
            randoms.add(0.5);
        } else if (a==3) {
            randoms.add(0.5);
            randoms.add(0.2);
        }
    }

    @Override
    public double nextRandom() {
        randoms.get(counter);
        counter++;
        return 0;
    }
}
