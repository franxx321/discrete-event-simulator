package gida.simulators.labs.first.utils;
import java.util.ArrayList;

public class CustomTestingRandomizer implements Randomizer {

    private ArrayList<Double> randoms;

    private int counter;

    public CustomTestingRandomizer(){
        randoms=new ArrayList<>();
        this.counter=0;

    }

    public ArrayList<Double> getRandoms() {
        return randoms;
    }

    public void setRandoms(ArrayList<Double> randoms) {
        this.randoms = randoms;
    }

    public int getCounter() {
        return counter;
    }

    public void sumCounter() {
        this.counter++;
    }

    @Override
    public double nextRandom() {
        double ret=randoms.get(counter);
        counter++;
        return ret;
    }
}
