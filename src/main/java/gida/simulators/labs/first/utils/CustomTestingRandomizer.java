package gida.simulators.labs.first.utils;
import java.util.ArrayList;

public abstract class CustomTestingRandomizer implements Randomizer {

    private ArrayList<Double> randoms;

    private int counter;

    public CustomTestingRandomizer(){
        this.counter=0;
        randoms=new ArrayList<>();
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


}
