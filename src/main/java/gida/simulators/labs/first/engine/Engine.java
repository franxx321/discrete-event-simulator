package gida.simulators.labs.first.engine;

/**
 * this interface defines the simulator functionalities
 */
public abstract class Engine implements Runnable {


    private boolean stop = false;

    public boolean isStop() {
        return stop;
    }

    public void setStop(boolean stop) {
        this.stop = stop;
    }



    public Engine() {

    }

    /**
     * stops the engine execution
     */
    public void stopExecute() {
        this.stop = true;
    }
}
