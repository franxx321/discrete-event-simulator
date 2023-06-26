package gida.simulators.labs.first.engine;

import gida.simulators.labs.first.entities.*;
import gida.simulators.labs.first.events.Event;
import gida.simulators.labs.first.resources.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CustomReport implements Reportable {

    private final String light = "Light Aircraft";

    private final String medium = "Medium Aircraft";

    private final String heavy = "Heavy Aircraft";

    private final String general ="General";

    private final String[] aircrafts = {light,medium,heavy,general};


    private final String cumulativeIdle = "Total Idle Time";

    private final String maxIdle= "Max Idle Time";

    private final String queueLength= "Max Queue Length";

    private final String durability= "End Durability";

    private final String idlePercentage = "Idle Percentage";

    private final String [] airstripKeys ={cumulativeIdle,maxIdle,queueLength,durability,idlePercentage};

    private final String queue = "Queue Time";

    private final String transit = "Transit Time";

    private final String[] times = {transit,queue};

    private final String max ="Maximum";

    private final String mean= "Mean";

    private final String[] type = {max,mean};

    //IMPORTANTE los Strings de arriba son para el manejo de los hashmaps


    private HashMap<String,HashMap<String,HashMap<String,Double>>> aircraftData;

    private HashMap<Integer,HashMap<String,Double>> airstripData;

    private HashMap<String,HashMap<String,HashMap<String,ArrayList<Double>>>> replicationAircraftData;

    private HashMap<Integer,HashMap<String,ArrayList<Double>>> replicationAirstripData;

    private ArrayList<Double> replicationEntityAmount;

    private double lastClock;

    private int entityAmount;

    private final int replicationsAmount;

    private int replicationsCount;

    private String calculateMeanInterval(ArrayList<Double> data){
        double acum=0;
        double currentMean=0;
        double stdDev=0;
        String ret;
        for (Double number: data) {
            acum+=number;
        }
        currentMean=acum/replicationsAmount-1;
        acum=0;
        for (Double number:data) {
            acum=Math.pow(number-currentMean,2);
        }
        stdDev=Math.sqrt(acum/replicationsAmount-1);
        ret="Mean: "+currentMean+" Confidence Interval: "+(currentMean-stdDev)+" - "+(currentMean+stdDev);
        return ret;
    }

    private void showresults(){
        System.out.println("Aircraft Data:\n");
        System.out.println("Aircraft Amount: ");
        System.out.println("\t"+calculateMeanInterval(this.replicationEntityAmount)+"\n\n");
        for (String key1:aircrafts) {
            for (String key2: times) {
                for (String key3:type){
                    System.out.println(key1+" "+key3+" "+key2+": ");
                    System.out.println("\t"+calculateMeanInterval(replicationAircraftData.get(key1).get(key2).get(key3))+"\n");
                }
            }
        }
        System.out.println("\n");
        System.out.println("Airstrip Data \n");
        for (Map.Entry<Integer,HashMap<String,ArrayList<Double>>> currentAirstripData : replicationAirstripData.entrySet()) {
            System.out.println( "Airstrip ID: "+currentAirstripData.getKey()+"\n");
            for (String key1: airstripKeys) {
                System.out.println(key1 +": ");
                System.out.println("\t"+calculateMeanInterval(currentAirstripData.getValue().get(key1))+"\n");
            }
        }
    }

    private void loadReplicationData(){
        for (String key1: aircrafts) {
            for (String key2:times) {
                for (String key3: type) {
                    if(key3.equals(mean)){
                        replicationAircraftData.get(key1).get(key2).get(key3).add(aircraftData.get(key1).get(key2).get(key3)/this.entityAmount);
                    }
                    else {
                        replicationAircraftData.get(key1).get(key2).get(key3).add(aircraftData.get(key1).get(key2).get(key3));
                    }
                }
            }
        }
        for (Map.Entry<Integer,HashMap<String,Double>> currentAirstripData:airstripData.entrySet()){
            checkReplicationAirstrip(currentAirstripData.getKey());
            for (String key1: airstripKeys) {
                if(key1.equals(idlePercentage)){
                    replicationAirstripData.get(currentAirstripData.getKey()).get(key1).add((currentAirstripData.getValue().get(key1)/this.lastClock));
                }

                else{
                    replicationAirstripData.get(currentAirstripData.getKey()).get(key1).add(currentAirstripData.getValue().get(key1));
                }
            }
        }
    }

    private void checkReplicationAirstrip(int id) {
        if(replicationAirstripData.get(id)==null){
            HashMap<String,ArrayList<Double>> currentHashmap = new HashMap<>();
            for (String key:airstripKeys) {
                currentHashmap.put(key,new ArrayList<>());
            }
            replicationAirstripData.put(id,currentHashmap);
        }
    }

    private void clearData(){
        for (String key1: aircrafts) {
            for (String key2:times) {
                for (String key3: type) {
                   aircraftData.get(key1).get(key2).put(key3,0.0);
                }
            }
        }
        for (Map.Entry<Integer,HashMap<String,Double>> currentAirstripData:airstripData.entrySet()){
            for (String key1: airstripKeys) {
               currentAirstripData.getValue().put(key1,0.0);
            }
        }
    }

    public CustomReport(int replicationsAmount) {
        this.replicationsAmount = replicationsAmount;
        this.replicationsCount=0;
        aircraftData=new HashMap<>();
        for (String key1:aircrafts) {
            HashMap<String,HashMap<String,Double>> timesHashmap =new HashMap<>();
            for (String key2:times) {
                HashMap<String,Double> typeHashMap = new HashMap<>();
                for (String key3:type) {
                    typeHashMap.put(key3,0.0);
                }
                timesHashmap.put(key2,typeHashMap);
            }
            aircraftData.put(key1,timesHashmap);
        }
        replicationAircraftData = new HashMap<>();
        for (String key1:aircrafts) {
            HashMap<String,HashMap<String,ArrayList<Double>>> timesHashmap =new HashMap<>();
            for (String key2:times) {
                HashMap<String,ArrayList<Double>> typeHashMap = new HashMap<>();
                for (String key3:type) {
                    typeHashMap.put(key3,new ArrayList<>());
                }
                timesHashmap.put(key2,typeHashMap);
            }
            replicationAircraftData.put(key1,timesHashmap);
        }
        replicationAirstripData= new HashMap<>();
        airstripData=new HashMap<>();
    }

    @Override
    public void generateReport() {
        if(replicationsCount<replicationsAmount){
            this.loadReplicationData();
            this.clearData();
            this.replicationsCount++;
        }
        else {
            this.showresults();
        }
    }

    private void checkAirstrip(Server server){
        if((airstripData.get(server.getId())==null)){
            HashMap<String,Double> currentAirStripData = new HashMap<>();
            currentAirStripData.put(maxIdle,0.0);
            currentAirStripData.put(cumulativeIdle,0.0);
            currentAirStripData.put(queueLength,0.0);
            currentAirStripData.put(durability,0.0);
            currentAirStripData.put(idlePercentage,0.0);
            airstripData.put(server.getId(),currentAirStripData);
        }
    }

    @Override
    public void calculateQueueTime(Event event, Entity entity) {
        double queueTime = event.getClock()-entity.getArrival().getClock();
        if(!(entity instanceof MaintenanceCrew)){
            if(queueTime > aircraftData.get(general).get(queue).get(max)) {
                aircraftData.get(general).get(queue).put(max,queueTime);
            }
            aircraftData.get(general).get(queue).merge(mean,queueTime, Double::sum);
        }
        if(entity instanceof LightAircraft){
                if(queueTime > aircraftData.get(light).get(queue).get(max)) {
                        aircraftData.get(light).get(queue).put(max,queueTime);
                        }
                    aircraftData.get(light).get(queue).merge(mean,queueTime, Double::sum);
        } else if(entity instanceof MediumAircraft) {
                    if(queueTime > aircraftData.get(medium).get(queue).get(max)) {
                        aircraftData.get(medium).get(queue).put(max,queueTime);
                        }
                    aircraftData.get(medium).get(queue).merge(mean,queueTime, Double::sum);

        }else if(entity instanceof HeavyAircraft){
                    if(queueTime > aircraftData.get(heavy).get(queue).get(max)) {
                        aircraftData.get(heavy).get(queue).put(max,queueTime);
                        }
                    aircraftData.get(heavy).get(queue).merge(mean,queueTime, Double::sum);
        }
    }

    @Override
    public void calculateTransitTime(Event event) {
        double transitTime = event.getClock()-event.getEntity().getArrival().getClock();
        if(!(event.getEntity() instanceof MaintenanceCrew)){
            if(transitTime > aircraftData.get(general).get(transit).get(max)) {
                aircraftData.get(general).get(transit).put(max,transitTime);
            }
            aircraftData.get(general).get(transit).merge(mean,transitTime, Double::sum);
        }
        if (event.getEntity() instanceof LightAircraft){
            if(transitTime > aircraftData.get(light).get(transit).get(max)) {
                aircraftData.get(light).get(transit).put(max,transitTime);
            }
            aircraftData.get(light).get(transit).merge(mean,transitTime, Double::sum);
        }
        if (event.getEntity() instanceof MediumAircraft){
            if(transitTime > aircraftData.get(medium).get(transit).get(max)) {
                aircraftData.get(medium).get(transit).put(max,transitTime);
            }
            aircraftData.get(medium).get(transit).merge(mean,transitTime, Double::sum);
        }
        if (event.getEntity() instanceof HeavyAircraft){
            if(transitTime > aircraftData.get(heavy).get(transit).get(max)) {
                aircraftData.get(heavy).get(transit).put(max,transitTime);
            }
            aircraftData.get(heavy).get(transit).merge(mean,transitTime, Double::sum);
        }
    }

    @Override
    public void calculateIdleTime(Server server, Event event) {
            double idleTime = event.getClock()-((Airstrip)server).getLastIdleStartTime();
            checkAirstrip(server);
            if (idleTime>airstripData.get(server.getId()).get(maxIdle)){
                airstripData.get(server.getId()).put(maxIdle,idleTime);
            }
            airstripData.get(server.getId()).merge(cumulativeIdle,idleTime, Double::sum);
    }

    @Override
    public void calculateQueueLength(Queue queue, Server server) {
        checkAirstrip(server);
        double queueLength = (double)queue.getSize();
        if(queueLength> airstripData.get(server.getId()).get(this.queueLength)){
            this.airstripData.get(server.getId()).put(this.queueLength,queueLength);
        }
    }

    @Override
    public void addEntityAmount() {
        this.entityAmount++;
    }

    @Override
    public void calculateEndAtributes(ArrayList<Server> servers) {
        for (Server server:servers) {
            checkAirstrip(server);
            Airstrip currentAirstrip = (Airstrip)server;
            airstripData.get(currentAirstrip.getId()).put(durability,(double)currentAirstrip.getDurability());
        }
    }




    public double getLastClock() {
        return lastClock;
    }

    public void setLastClock(double lastClock) {
        this.lastClock = lastClock;
    }
}


