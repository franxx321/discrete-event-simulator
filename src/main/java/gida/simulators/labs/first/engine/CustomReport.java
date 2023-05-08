package gida.simulators.labs.first.engine;

import java.text.DecimalFormat;

public class CustomReport implements Reportable {

    private double totalIdleTime, totalQueueTime,maxIdleTime,maxQueueTime,totalTransitTime,maxTransitTime,lastClock;

    private int maxServerQueueLength;

    private int entityAmount;
    @Override
    public void generateReport() {
        DecimalFormat decimalFormat = new DecimalFormat("#.00");
        // TODO Auto-generated method stub
        System.out.println("Reporte simulacion:");
        System.out.println("El tiempo maximo de Espera es: "+this.getMaxQueueTime()+"\tEl tiempo maximo de transito es: "+this.getMaxTransitTime());
        System.out.println("El tiempo total de Espera es: "+this.totalQueueTime+"\tEl tiempo total de transito es: "+this.totalTransitTime);
        System.out.println("El tiempo medio de Espera es: "+(double)(this.totalQueueTime/this.entityAmount)+"\tEl tiempo medio de transito es: "+(double)(this.totalTransitTime/this.entityAmount));
        System.out.println("El tiempo total de ocio es: "+this.totalIdleTime+" y representa el "+ (decimalFormat.format((this.totalIdleTime/this.lastClock)*100))+"% del tiempo total");
        System.out.println("El tiempo maximo de ocio es: "+this.maxIdleTime+" y representa el "+(decimalFormat.format((this.maxIdleTime/this.totalIdleTime)*100))+"% del tiempo de ocio total");
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

    public int getMaxServerQueueLength() {
        return maxServerQueueLength;
    }

    public void setMaxServerQueueLength(int maxServerQueueLength) {
        this.maxServerQueueLength = maxServerQueueLength;
    }

    public double getMaxTransitTime() {
        return maxTransitTime;
    }

    public void setMaxTransitTime(double maxTransitTime) {
        this.maxTransitTime = maxTransitTime;
    }

    public double getTotalTransitTime() {
        return totalTransitTime;
    }

    public void sumTransitTime(double transitTime){
        this.totalTransitTime+=transitTime;
    }

    public double getLastClock() {
        return lastClock;
    }

    public void setLastClock(double lastClock) {
        this.lastClock = lastClock;
    }
}


