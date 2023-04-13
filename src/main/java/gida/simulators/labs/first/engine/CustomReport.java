package gida.simulators.labs.first.engine;

public class CustomReport implements Reportable {

    private double totalIdleTime, totalQueueTime,maxIdleTime,maxQueueTime;

    private int entityAmount;

    @Override
    public void generateReport() {
        // TODO Auto-generated method stub
        System.out.println("Reporte simulacion:");
        System.out.println("El tiempo maximo de Espera es: "+this.getMaxQueueTime()+"\tEl tiempo maximo de ocio es: "+this.getMaxIdleTime());
        System.out.println("El tiempo total de Espera es: "+this.totalQueueTime+"\tEl tiempo total de ocio es: "+this.totalIdleTime);
        System.out.println("El tiempo medio de Espera es: "+(double)(this.totalQueueTime/this.entityAmount)+"\tEl tiempo medio de ocio es: "+(double)(this.totalIdleTime/this.entityAmount));
        //throw new UnsupportedOperationException("Unimplemented method 'generateReport'");
    }

    public double getIdletime() {
        return this.totalIdleTime;
    }

    public void sumIdletime(double idletime) {
        this.totalIdleTime += idletime;
    }

    public double getQueuetime() {
        return this.totalQueueTime;
    }

    public void sumQueuetime(double queuetime) {
        this.totalQueueTime += queuetime;
    }

    public int getEntityAmount() {
        return entityAmount;
    }

    public void addEntityAmount() {
        this.entityAmount ++;
    }

    public double getMaxIdleTime() {
        return this.maxIdleTime;
    }

    public void setMaxIdleTime(double maxIdleTime) {
        this.maxIdleTime = maxIdleTime;
    }

    public double getMaxQueueTime() {
        return this.maxQueueTime;
    }

    public void setMaxQueueTime(double maxQueueTime) {
        this.maxQueueTime = maxQueueTime;
    }
}
