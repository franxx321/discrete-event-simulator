package gida.simulators.labs.first.engine;

public class CustomReport implements Reportable {

    private double idletime, queuetime;

    private int entityAmount;

    @Override
    public void generateReport() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'generateReport'");
    }

    public double getIdletime() {
        return idletime;
    }

    public void sumIdletime(double idletime) {
        this.idletime += idletime;
    }

    public double getQueuetime() {
        return queuetime;
    }

    public void sumQueuetime(double queuetime) {
        this.queuetime += queuetime;
    }

    public int getEntityAmount() {
        return entityAmount;
    }

    public void addEntityAmount() {
        this.entityAmount ++;
    }
}
