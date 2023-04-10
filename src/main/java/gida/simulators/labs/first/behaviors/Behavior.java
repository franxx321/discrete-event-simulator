package gida.simulators.labs.first.behaviors;

@FunctionalInterface
public interface Behavior {

    /**
     * calculates a time span
     * 
     * @return the value for that time span
     */
    double nextTime();
}
